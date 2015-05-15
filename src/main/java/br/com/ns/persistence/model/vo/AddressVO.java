package br.com.ns.persistence.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * VO para manipulação de Endereços
 * 
 * @author Rodrigo Braga
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3058524000092326572L;

	private String zipCode;

	private String street;

	private String district;

	private String city;

	private String state;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
