package com.chrisvasconi.loginreg.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisvasconi.loginreg.models.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
	// search for email
	Optional<User> findByEmail(String email);
	
	
}
