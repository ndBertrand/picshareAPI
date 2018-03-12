package com.picshare.PicshareProject.repository;

import com.picshare.PicshareProject.model.User;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
	
		 User findByEmail(String email);
		 String findRoleByEmail(String email);

		Optional<User> findByUsername(String username);

	 
	  
	
}
