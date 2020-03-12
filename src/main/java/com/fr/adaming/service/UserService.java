package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDAO;
import com.fr.adaming.entity.User;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO dao;

	@Override
	public User create(User user) {
		if (user == null || dao.existsByEmail(user.getEmail())) {
			// l'utilisateur existe déjà
			return null;
		} else {
			dao.save(user);
			return user;
		}
	}

	@Override
	public List<User> readAll() {
		return dao.findAll();
	}

	@Override
	public User readById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public boolean update(User user) {

		if (user == null || !dao.existsById(user.getId())) {
			// l'utilisateur n'existe pas
			return false;
		} else {
			dao.save(user);
			return true;
		}

	}

	@Override
	public boolean deleteById(int id) {
		if (!dao.existsById(id)) {
			return false;
		}
		dao.deleteById(id);
		return true;
	}

	

}
