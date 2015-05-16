package br.com.ns.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ns.exception.InvalidZipcodeFormatException;
import br.com.ns.exception.ResourceNotFoundException;
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
@RequestMapping(value = "/address", produces = { MediaType.APPLICATION_JSON_VALUE })
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

	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {

		try {
			service.addAddress(address);

			return new ResponseEntity<Address>(HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "{addressId}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> getAddress(@PathVariable("addressId") Long id) {
		try {
			Address address = service.getAddress(id);

			return new ResponseEntity<Address>(address, HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "{addressId}", method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> updateAddress(@RequestBody Address address,
			@PathVariable("addressId") Long id) {

		try {
			address.setId(id);
			service.updateAddress(address);

			return new ResponseEntity<Address>(HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "{addressId}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> deleteAddress(
			@PathVariable("addressId") Long id) {

		try {
			service.deleteAddress(id);

			return new ResponseEntity<Address>(HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}

	}

}
