package com.greatlearning.employee_management.userdetailsImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.employee_management.model.Role;
import com.greatlearning.employee_management.model.User;

public class MyUserDetails implements UserDetails {

	@Autowired
	private User user;

	public MyUserDetails(User user) {
		this.user = user;
	}

	/*
	 * creating a list of SimpleGrantedAuthority objects 
	 * by passing it role names
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<Role> roles = user.getRoles();

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles)
			authorities.add(new SimpleGrantedAuthority(role.getName()));

		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// Other fileds to be hardcoded
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
