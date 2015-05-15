package br.com.ns.service;

import br.com.ns.persistence.model.entity.Address;

/**
 * Interface para serviços relacionados a endereço
 * 
 * @author Rodrigo Braga
 *
 */
public interface AddressService {

	/**
	 * Pesquisa endereço por cep
	 * 
	 * @param zipCode
	 *            - cep {@link String}
	 * @return - Endereço {@link Address}
	 */
	public Address getAddress(String zipCode);
	

}
