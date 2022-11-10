package com.greatlearning.employee_management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employee_management.dao.UserRepository;
import com.greatlearning.employee_management.model.User;
import com.greatlearning.employee_management.userdetailsImpl.MyUserDetails;

import lombok.RequiredArgsConstructor;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("Sorry!\nCould not find the user");

		return new MyUserDetails(user);
	}

}
