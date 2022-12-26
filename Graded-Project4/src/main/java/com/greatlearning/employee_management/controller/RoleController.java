package com.greatlearning.employee_management.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee_management.model.Role;
import com.greatlearning.employee_management.service.RoleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@ApiOperation(value = "List all Roles", notes = "This API allows you to list all roles from the roles table")
	@GetMapping
	public List<Role> listAllRoles() {
		return roleService.findAllRoles();
	}

	@ApiOperation(value = "Add Single Role", notes = "This API allows you to add a single Role to the roles table")
	@PostMapping
	@ResponseStatus(CREATED)
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	@ApiOperation(value = "Update Role", notes = "Role is not fetched by Id. Please specify correct Role Id for updation")
	@PutMapping
	public Role updateRole(@RequestBody Role role) {
		return roleService.updateRole(role);
	}

	@ApiOperation(value = "Delete Role by Id", notes = "This API allows you to delete a Role by Id from the roles table")
	@DeleteMapping("/{roleId}")
	@ResponseStatus(NO_CONTENT)
	public String deleteRoleById(@PathVariable("roleId") int id) {
		roleService.deleteRoleById(id);

		return "Deleted role with id : " + id;
	}
}
