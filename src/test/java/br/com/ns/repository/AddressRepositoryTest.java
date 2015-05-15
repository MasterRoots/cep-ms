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
	public void deveTer2Enderecos() {

		// WHEN
		long count = repository.count();

		// THEN
		Assert.assertEquals(2, count);
	}
	
}
