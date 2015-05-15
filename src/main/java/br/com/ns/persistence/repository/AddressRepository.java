/**
 * 
 */
package br.com.ns.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ns.persistence.model.entity.Address;

/**
 * Repositório de dados para endereços
 * 
 * @author Rodrigo Braga
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

	@Query(value = "select a from Address a where a.zipCode = :zipcode")
	public Address findByZipCode(@Param("zipCode") String zipCode);

}
