package com.practice.project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.project4.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
