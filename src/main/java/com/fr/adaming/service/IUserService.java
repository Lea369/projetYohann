package com.fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.User;


@Service
public interface IUserService {
	// create
	/**
	 * @param user the given entity
	 * @return null if there is a problem, else the user after creating
	 */
	public User create(User user);

	// readAll

	/**
	 * @return may be empty
	 */
	public List<User> readAll();

	// readById
	/**
	 * @param id the given id
	 * @return the user or null
	 */
	public User readById(int id);



	// update
	/**
	 * @param user the given user
	 * @return false if not found user by id, true if SUCCESS
	 */
	@Transactional
	public boolean update(User user);

	// deleteById
	@Transactional
	public boolean deleteById(int id);

}
