package com.practice.project4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.project4.model.User;
import com.practice.project4.repository.UserRepository;
import com.practice.project4.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User updatedUser) {
		User savedUser = userRepository.findById(updatedUser.getId()).get();

		savedUser.setUsername(updatedUser.getUsername());
		savedUser.setPassword(updatedUser.getPassword());
		savedUser.setRoles(updatedUser.getRoles());

		return userRepository.save(savedUser);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

}
