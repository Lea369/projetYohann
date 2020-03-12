package com.fr.adaming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
	
	private boolean isError;
	
	private String message;
	
	private Object objet;
	

}
