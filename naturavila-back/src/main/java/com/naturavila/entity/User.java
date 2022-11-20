package com.naturavila.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	private Long id;
	
	@NotBlank(message = "firstName is mandatory")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message = "identifier is mandatory")
	@Column(unique=true)
	private String identifier;
	
	private String email;
	
	@NotBlank(message = "password is mandatory")
	private String password;

}
