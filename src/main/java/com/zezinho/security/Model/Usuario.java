package com.zezinho.security.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usuario_id;
	
	@NotBlank(message = "O campo não pode estar vazio")
	//@Length(min = 2, max= 30, message = "O campo não ter menos de dois ou acima de 30 de caracteres")
	private String name;
	
	@NotBlank(message = "O campo não pode estar vazio")
	//@Length(min = 5, max= 30, message = "O campo não ter menos de dois ou acima de 30 de caracteres")
	private String password;
	
	@NotBlank(message = "O campo não pode estar vazio")
	private String firstName;
	
	@NotBlank(message = "O campo não pode estar vazio")
	private String lastName;

	public long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	
}
