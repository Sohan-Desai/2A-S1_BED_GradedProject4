package com.practice.project4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.project4.model.Role;
import com.practice.project4.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public List<Role> listAllRoles() {
		return roleService.findAllRoles();
	}

	@PostMapping
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	@PutMapping
	public Role updateRole(@RequestBody Role role) {
		return roleService.updateRole(role);
	}

	@DeleteMapping("/{roleId}")
	public String deleteRoleById(@PathVariable("roleId") int id) {
		roleService.deleteRoleById(id);

		return "Deleted role with id : " + id;
	}
}
