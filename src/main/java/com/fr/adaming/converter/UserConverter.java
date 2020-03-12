package com.fr.adaming.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.dto.UserCreateDTO;
import com.fr.adaming.dto.UserUpdateDTO;
import com.fr.adaming.entity.User;



public class UserConverter {

	public static UserCreateDTO UserToUserCreateDTo(User u) {
		
		if(u==null) {
			return null;
		}
	
			UserCreateDTO udto = new UserCreateDTO();

			udto.setFirstname(u.getPrenom());
			udto.setMail(u.getEmail());
			udto.setPassword(u.getPwd());
			udto.setSurname(u.getNom());
			return udto;

		
	}

	public static User UserCreateDtoToUser (UserCreateDTO udto) {

		if(udto==null) {
			return null;
		}
		
			User u = new User();

			u.setEmail(udto.getMail());
			u.setNom(udto.getSurname());
			u.setPrenom(udto.getFirstname());
			u.setPwd(udto.getPassword());
			return u;


	}
	
	public static User UserUpdateDtoToUser(UserUpdateDTO udto) {
		

		if(udto==null) {
			return null;
		}
		User u = new User();

		u.setEmail(udto.getMail());
		u.setNom(udto.getSurname());
		u.setPrenom(udto.getFirstname());
		u.setPwd(udto.getPassword());
		u.setId(udto.getId());
		
		return u;
	}
	
	public static UserUpdateDTO UserToUserUpdateDto(User u) {
		

		if(u==null) {
			return null;
		}
		UserUpdateDTO udto = new UserUpdateDTO();

		udto.setFirstname(u.getPrenom());
		udto.setMail(u.getEmail());
		udto.setPassword(u.getPwd());
		udto.setSurname(u.getNom());
		udto.setId(u.getId());
		return udto;
	
	}

	public static List<User> ListUserUpdateDtoToUser(List<UserUpdateDTO> dtolist) {

		List<User> plist = new ArrayList<User>();

		for (UserUpdateDTO pdto : dtolist) {

			plist.add(UserUpdateDtoToUser(pdto));

		}
		return plist;
	}

	

	public static List<UserUpdateDTO> ListUserToUserUpdateDto(List<User> ulist) {

		List<UserUpdateDTO> dtolist = new ArrayList<UserUpdateDTO>();

		for (User u : ulist) {

			dtolist.add(UserToUserUpdateDto(u));
		}

		return dtolist;
	}



}

