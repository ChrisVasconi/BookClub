package com.chrisvasconi.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrisvasconi.loginreg.models.LoginUser;
import com.chrisvasconi.loginreg.models.User;
import com.chrisvasconi.loginreg.repositories.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
        //TO DO Reject Values
		
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "This email is already in use");
		}
		//Reject if password doesn't match
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "The password does not match");
		}
		
		//Return null if result has errors
		if(result.hasErrors()) {
			return null;
		}
		
		//Hash and set password, save user
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
    }
	  public User login(LoginUser newLoginObject, BindingResult result) {
	        // TO-DO - Reject values:
	        //1. Find user in the DB by email
		  Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
	    	// Find user in the DB by email
	      if (!potentialUser.isPresent()) {
	      	result.rejectValue("email", "unique", "The email is not registered");
		  //2. If email is not present, reject that ish
	      	return null;
	      }
	        
	      	//3.1 grab the user from the potential user
	      User user = potentialUser.get();
	      	
	        // 3.2 if BCrypt password match fails
	      if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
	    	  result.rejectValue("password", "Matches", "Invalid Password");
	      }
	        //4 Return null if result has errors
	       if(result.hasErrors()) {
	    	   
	       }
	      //5 Otherwise, return the user object
	       return user;
	  }
	  public User oneUser(Long id) {
		  Optional<User> optionalUser = userRepo.findById(id);
		  if(optionalUser.isPresent()) {
			  return optionalUser.get();
		  }else {
			  return null;
		  }
	  }

}