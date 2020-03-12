package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.converter.UserConverter;
import com.fr.adaming.dto.ResponseDTO;
import com.fr.adaming.dto.UserCreateDTO;
import com.fr.adaming.dto.UserUpdateDTO;
import com.fr.adaming.service.IUserService;


@RestController
public class UserController implements IUserController {
	
	
	@Autowired
	private IUserService service;

	@Override
	public ResponseEntity<ResponseDTO> afficherUsers() {
		List<UserUpdateDTO> users = UserConverter.ListUserToUserUpdateDto(service.readAll());
		ResponseDTO resp = null;
		if (users !=null) {
			resp = new ResponseDTO(false, "SUCCESS", users);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}
		resp = new ResponseDTO(true, "FAIL", null);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@Override
	public ResponseEntity<ResponseDTO> create(UserCreateDTO dto) {
		ResponseDTO resp = null;

		UserCreateDTO dtoResp = UserConverter
				.UserToUserCreateDTo(service.create(UserConverter.UserCreateDtoToUser(dto)));

		if (dtoResp != null) {
			// Success
			resp = new ResponseDTO(false, "SUCCESS", dtoResp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		} else {
			// fail
			resp = new ResponseDTO(true, "FAIL", null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> readById(int id) {
		UserUpdateDTO u = UserConverter.UserToUserUpdateDto(service.readById(id));
		ResponseDTO resp = null;

		if (u != null) {
			// SUCCESS
			resp = new ResponseDTO(false, "SUCCESS", u);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		} else {
			// FAIL
			resp = new ResponseDTO(true, "FAIL", null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);

		}
	}

	@Override
	public ResponseEntity<ResponseDTO> update(UserUpdateDTO dto) {
		boolean result = service.update(UserConverter.UserUpdateDtoToUser(dto));
		ResponseDTO resp = null;
		
		if(result){

			resp = new ResponseDTO(false, "SUCCESS", null);
			
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}else {

			resp = new ResponseDTO(true, "FAIL", null);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
			
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteById(int id) {
		boolean result = service.deleteById(id);
		ResponseDTO resp = null;
		
		if(result){

			resp = new ResponseDTO(false, "SUCCESS", null);
			
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}else {

			resp = new ResponseDTO(true, "FAIL", null);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
			
		}
	}

	
	

}
