package com.fr.adaming.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.ResponseDTO;
import com.fr.adaming.dto.UserCreateDTO;
import com.fr.adaming.dto.UserUpdateDTO;



@RestController
@RequestMapping(path="/users")
public interface IUserController {
	

	@GetMapping
	public ResponseEntity<ResponseDTO> afficherUsers();
	
	
	@PostMapping
	public ResponseEntity<ResponseDTO> create(@RequestBody @Valid UserCreateDTO dto);

	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseDTO> readById(@PathVariable(name = "id") int id);
	
	@PutMapping
	public ResponseEntity<ResponseDTO> update(@RequestBody @Valid UserUpdateDTO dto);
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable(name = "id") int id);
	

}
