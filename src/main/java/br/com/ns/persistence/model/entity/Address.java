package br.com.ns.persistence.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidade para representar um Endereço
 * 
 * @author Rodrigo Braga
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1502436746157435874L;

	/**
	 * Construtor padrão
	 */
	public Address() {
		// Empty
	}

	/**
	 * Construtor customizado
	 * 
	 * @param id
	 *            - CEP {@link Long}
	 * @param zipCode
	 *            - CEP {@link String}
	 * @param street
	 *            - Rua {@link String}
	 * @param district
	 *            - Bairro {@link String}
	 * @param city
	 *            - Cidade {@link String}
	 * @param state
	 *            - Estado {@link String}
	 */
	public Address(Long id, String zipCode, String street, String district,
			String city, String state) {
		this.id = id;
		this.zipCode = zipCode;
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;

	}

	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "zipcode")
	@NotNull
	@NotEmpty
	private String zipCode;

	@NotNull
	@NotEmpty
	@Column(name = "street")
	private String street;

	@NotNull
	@NotEmpty
	@Column(name = "district")
	private String district;

	@NotNull
	@NotEmpty
	@Column(name = "city")
	private String city;

	@NotNull
	@NotEmpty
	@Column(name = "state")
	private String state;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Address[id=%s, zipcode=%s, street=%s, district=%s, city=%s, state=%s]",
						id, zipCode, street, district, city, state);
	}

}
