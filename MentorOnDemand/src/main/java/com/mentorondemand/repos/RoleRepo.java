package com.mentorondemand.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mentorondemand.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
	
	Role findByRoleName(String roleName);
}
