/**
 * 
 */
package br.com.ns.repository;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.ns.App;
import br.com.ns.persistence.repository.AddressRepository;

/**
 * 
 * @author Rodrigo Braga
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class AddressRepositoryTest {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private DataSource datasource;

	
}
