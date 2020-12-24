package com.mentorondemand.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
	public User findByEmail(String email);

public User findByName(String name);

}


