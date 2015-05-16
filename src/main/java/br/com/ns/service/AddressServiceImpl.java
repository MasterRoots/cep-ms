package br.com.ns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ns.exception.InvalidZipcodeFormatException;
import br.com.ns.exception.ResourceNotFoundException;
import br.com.ns.persistence.model.entity.Address;
import br.com.ns.persistence.repository.AddressRepository;

/**
 * Implementação de serviços de Endereço
 * 
 * @author Rodrigo Braga
 *
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

	private static final char ZIP_CODE_SUFIX_DIGIT = '0';

	private static final int ZIP_CODE_SUFIX_SIZE = 3;

	private static final int ZIP_CODE_SIZE = 7;

	@Autowired
	private AddressRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.ns.service.AddressService#getAddress(java.lang.String)
	 */

	@Override
	public Address getAddress(String zipCode) {
		return zipCodeAttemptsSearch(zipCode);
	}

	/**
	 * Executa a pesquisa do CEP, caso não encontre um resultado, faço novas
	 * tentativas corrigindo o sufixo
	 * 
	 * @param zipCode
	 *            - CEP - {@link String}
	 * @return {@link Address}
	 */
	public Address zipCodeAttemptsSearch(String zipCode) {

		Address address = repository.findByZipCode(zipCode);

		if (address == null) {

			StringBuilder s = new StringBuilder(zipCode);

			for (int i = 0; i < ZIP_CODE_SUFIX_SIZE; i++) {

				s.setCharAt(ZIP_CODE_SIZE - i, ZIP_CODE_SUFIX_DIGIT);

				address = repository.findByZipCode(s.toString());

				if (address != null) {
					return address;
				} else if (address == null && i == ZIP_CODE_SUFIX_SIZE - 1) {
					throw new InvalidZipcodeFormatException();
				}

			}
		}

		return address;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.ns.service.AddressService#getAddress(java.lang.Long)
	 */
	@Override
	public Address getAddress(Long id) {

		try {
			Address address = repository.findOne(id);

			if (address != null) {
				return address;
			} else {
				throw new ResourceNotFoundException();
			}

		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.ns.service.AddressService#updateAddress(br.com.ns.persistence.
	 * model.entity.Address)
	 */
	@Override
	public void updateAddress(Address address) {

		try {
			repository.save(address);
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.ns.service.AddressService#deleteAddress(br.com.ns.persistence.
	 * model.entity.Address)
	 */
	@Override
	public void deleteAddress(Long id) {
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.ns.service.AddressService#addAddress(br.com.ns.persistence.model
	 * .entity.Address)
	 */
	@Override
	public Long addAddress(Address address) {
		try {
			Address newAddress = repository.save(address);
			return newAddress.getId();

		} catch (Exception e) {
			throw e;
		}
	}

}
