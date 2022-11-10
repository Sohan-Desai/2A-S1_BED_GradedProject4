package com.greatlearning.employee_management.service;

import java.util.List;

import com.greatlearning.employee_management.model.Role;

public interface RoleService {

	List<Role> findAllRoles();

	Role saveRole(Role role);

	Role updateRole(Role role);

	void deleteRoleById(int id);

}
