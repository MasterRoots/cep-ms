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

	/**
	 * Adiciona uma nova empresa
	 * 
	 * @param address
	 *            {@link Address}
	 * @return {@link Long} - id
	 */
	public Long addAddress(Address address);

	/**
	 * Retorna um Endereço
	 * 
	 * @param id
	 *            - id do endereço
	 * @return {@link Address}
	 */
	public Address getAddress(Long id);

	/**
	 * Atualiza um endereço
	 * 
	 * @param address
	 *            - {@link Address}
	 */
	public void updateAddress(Address address);

	/**
	 * Remove um endereço
	 * 
	 * @param {@link Long} - id
	 */
	public void deleteAddress(Long id);

}
