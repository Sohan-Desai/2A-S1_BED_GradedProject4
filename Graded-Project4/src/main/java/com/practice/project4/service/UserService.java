package com.practice.project4.service;

import java.util.List;

import com.practice.project4.model.User;

public interface UserService {

	List<User> findAllUsers();

	User saveUser(User user);

	User updateUser(User user);

	void deleteUserById(int id);

}
