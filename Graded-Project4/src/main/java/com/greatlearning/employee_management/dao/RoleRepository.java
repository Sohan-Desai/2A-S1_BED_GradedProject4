package com.greatlearning.employee_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employee_management.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
