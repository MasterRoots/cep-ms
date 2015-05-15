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

	@Autowired
	private WebApplicationContext webApplicationContext;

	/**
	 * 
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void deveBuscarUmEnderecoPorCEP() throws Exception {

		// WHEN
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/address/?zipcode=08260210").contentType(MediaType.APPLICATION_JSON));

		// THEN
		resultActions.andDo(MockMvcResultHandlers.print());

		resultActions.andExpect(MockMvcResultMatchers.content().contentType("application/json"));

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());

		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()));


		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("08260210"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.street").value("rua adolfo appia"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.district").value("itaquera"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.city").value("SAO PAULO"));
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.state").value("SP"));
	}


}
