package com.picshare.PicshareProject.repository;

import com.picshare.PicshareProject.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
	
	 User findByEmail(String email);
	//List<User> findDistinctByUser_LastnameOrUser_Firstname(String lastname,String firstname);
	
}
