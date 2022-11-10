package com.greatlearning.employee_management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee_management.dao.RoleRepository;
import com.greatlearning.employee_management.model.Role;
import com.greatlearning.employee_management.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role updatedRole) {
		
		Role savedRole = roleRepository.findById(updatedRole.getId()).get();

		savedRole.setName(updatedRole.getName());
		return roleRepository.save(savedRole);
	}

	@Override
	public void deleteRoleById(int id) {
		roleRepository.deleteById(id);
	}

}
