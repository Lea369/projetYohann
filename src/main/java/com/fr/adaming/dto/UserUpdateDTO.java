package com.fr.adaming.dto;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateDTO extends UserCreateDTO{
	
	
	@NotNull
	int id;

}
