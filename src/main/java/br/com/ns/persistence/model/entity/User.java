package br.com.ns.persistence.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidadepara representar um usuário
 * 
 * @author rodrigo.braga
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7305554970435346791L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String username;

	@NotNull
	@NotEmpty
	private String name;

	@OneToMany(targetEntity = Address.class)
	@JoinColumn(name = "user_id")
	private List<Address> addresses;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	
}
