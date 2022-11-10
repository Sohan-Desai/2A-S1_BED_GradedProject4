package com.greatlearning.employee_management.service;

import java.util.List;

import com.greatlearning.employee_management.model.User;

public interface UserService {

	List<User> findAllUsers();

	User saveUser(User user);

	User updateUser(User user);

	void deleteUserById(int id);

}
