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
	protected Address() {
		// Empty
	}

	/**
	 * Construtor customizado
	 * 
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
	public Address(String zipCode, String street, String district, String city,
			String state) {

	}

	@Id
	@GeneratedValue
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
	private Integer zipCode;

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

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
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
				.format("Address[zipcode=%s, street=%s, district=%s, city=%s, state=%s]",
						zipCode, street, district, city, state);
	}

}
