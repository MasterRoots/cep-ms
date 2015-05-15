package br.com.ns.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ns.exception.InvalidZipcodeFormatException;
import br.com.ns.persistence.model.entity.Address;
import br.com.ns.service.AddressService;

/**
 * 
 * Controller para recursos de CEP
 * 
 * @author Rodrigo Braga
 *
 */
@RestController
@RequestMapping(value = "/address/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AddressController {

	@Autowired
	private AddressService service;

	@RequestMapping(value = "", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> getAddressBy(
			@RequestParam("zipcode") String zipCode) {

		try {
			Address address = service.getAddress(zipCode);
			return new ResponseEntity<Address>(address, HttpStatus.OK);

		} catch (InvalidZipcodeFormatException e) {
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}

	}

}
