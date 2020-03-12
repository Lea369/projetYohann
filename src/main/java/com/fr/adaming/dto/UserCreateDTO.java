package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserCreateDTO {
	
	
	@NotBlank
	private String surname;
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	@Email
	private String mail;
	
	@NotBlank
	private String password; 
	

}
