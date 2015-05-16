/**
 * 
 */
package br.com.ns.rest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.ns.App;
import br.com.ns.persistence.model.entity.Address;
import br.com.ns.service.AddressService;

import com.google.gson.Gson;

/**
 * 
 * @author Rodrigo Braga
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest({ "server.port:10100" })
public class AddressControllerTest {

	private MockMvc mockMvc;

	private Gson gson = new Gson();

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private AddressService addressService;

	/**
	 * 
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void deveBuscarUmEnderecoPorCEP() throws Exception {

		// WHEN
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
				.get("/address/?zipcode=08260210").contentType(
						MediaType.APPLICATION_JSON));

		// THEN
		resultActions.andDo(MockMvcResultHandlers.print());

		resultActions.andExpect(MockMvcResultMatchers.content().contentType(
				"application/json"));

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());

		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$",
				Matchers.notNullValue()));

		resultActions
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.zipCode")
				.value("08260210"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.street")
				.value("rua adolfo appia"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.district")
				.value("itaquera"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.city").value(
				"SAO PAULO"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.state")
				.value("SP"));
	}

	@Test
	public void deveBuscarUmEnderecoPorId() throws Exception {

		// WHEN
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
				.get("/address/1").contentType(MediaType.APPLICATION_JSON));

		// THEN
		resultActions.andDo(MockMvcResultHandlers.print());

		resultActions.andExpect(MockMvcResultMatchers.content().contentType(
				"application/json"));

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());

		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$",
				Matchers.notNullValue()));

		resultActions
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.zipCode")
				.value("08260210"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.street")
				.value("rua adolfo appia"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.district")
				.value("itaquera"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.city").value(
				"SAO PAULO"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.state")
				.value("SP"));

	}

	@Test
	public void deveMostrar404SeNaoAcharEndereco() throws Exception {

		// WHEN
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
				.get("/address/5454").contentType(MediaType.APPLICATION_JSON));

		// THEN
		resultActions.andDo(MockMvcResultHandlers.print());

		resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void deveInserirUmEndereco() throws Exception {

		// GIVEN
		Address address = new Address();

		address.setCity("Maringa");
		address.setDistrict("itauba");
		address.setState("PR");
		address.setZipCode("17963450");
		address.setStreet("Rua X");

		// THEN
		mockMvc.perform(
				MockMvcRequestBuilders.post("/address")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(gson.toJson(address))
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(201));

	}

	@Test
	public void deveAtualizarUmEndereco() throws Exception {

		// GIVEN
		Address address = new Address();

		address.setId(1l);
		address.setCity("Maringa");
		address.setDistrict("itauba");
		address.setState("PR");
		address.setZipCode("17963450");
		address.setStreet("Rua X");

		// THEN
		mockMvc.perform(
				MockMvcRequestBuilders.put("/address/2")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(gson.toJson(address))
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void deveExcluirUmEndereco() throws Exception {
		// THEN
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/address/2")
						.contentType(MediaType.APPLICATION_JSON_VALUE)

						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
