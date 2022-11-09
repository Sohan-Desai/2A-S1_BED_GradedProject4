package com.practice.project4.service;

import java.util.List;

import com.practice.project4.model.Role;

public interface RoleService {

	List<Role> findAllRoles();

	Role saveRole(Role role);

	Role updateRole(Role role);

	void deleteRoleById(int id);

}
