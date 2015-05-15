/**
 * 
 */
package br.com.ns.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ns.App;
import br.com.ns.persistence.model.entity.Address;
import br.com.ns.persistence.repository.AddressRepository;

/**
 * 
 * @author Rodrigo Braga
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class AddressRepositoryTest {

	@Autowired
	private AddressRepository repository;

	
	@Test
	public void deveBuscarEnderecoPorId() {

		// WHEN
		Address address = repository.findOne(2L);

		// THEN
		Assert.assertEquals("08450789", address.getZipCode());
	}

	@Test
	public void deveAtualizarEndereco() {

		// GIVEN
		Address address = new Address(1l, "08260210", "rua adolfo appia, 39 ",
				"itaquera", "São Paulo", "SP");

		// WHEN
		repository.save(address);
		Address expectedAddress = repository.findOne(1l);

		// THEN
		Assert.assertEquals(expectedAddress.getZipCode(), "08260210");
		Assert.assertEquals(expectedAddress.getStreet(),
				"rua adolfo appia, 39 ");
		Assert.assertEquals(expectedAddress.getDistrict(), "itaquera");
		Assert.assertEquals(expectedAddress.getCity(), "São Paulo");
		Assert.assertEquals(expectedAddress.getState(), "SP");
	}

	@Test
	public void deveSalvarEndereco() {
		// GIVEN
		Address address = new Address(null, "08260211", "rua Francesco ",
				"Vila Mariana", "São Paulo", "SP");

		// WHEN
		repository.save(address);
		Address expectedAddress = repository.findOne(3l);

		// THEN
		Assert.assertEquals(expectedAddress.getZipCode(), "08260211");
		Assert.assertEquals(expectedAddress.getStreet(), "rua Francesco ");
		Assert.assertEquals(expectedAddress.getDistrict(), "Vila Mariana");
		Assert.assertEquals(expectedAddress.getCity(), "São Paulo");
		Assert.assertEquals(expectedAddress.getState(), "SP");
	}

	@Test
	public void deveDeletarEndereco() {
		// GIVEN
		Address address = new Address(null, "08260212", "rua jose",
				"Vila Madalena", "São Paulo", "SP");
		// WHEN
		Address addressDeleted = repository.save(address);
		
		repository.delete(addressDeleted.getId());

		// THEN
		Assert.assertNull(repository.findOne(addressDeleted.getId()));

	}
}
