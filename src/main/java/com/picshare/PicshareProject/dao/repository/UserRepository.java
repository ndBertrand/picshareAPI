package com.picshare.PicshareProject.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picshare.PicshareProject.dao.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	String findRoleByEmail(String email);

	Optional<User> findByUsername(String username);

}
