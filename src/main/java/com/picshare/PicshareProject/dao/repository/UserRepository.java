package com.picshare.PicshareProject.dao.repository;


import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.picshare.PicshareProject.dao.entities.User;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(@Param("email") String email);

	String findRoleByEmail(String email);

	Optional<User> findByUsername(String username);

	@Query("select u from User u")
	List<User> getAllUser();

	@Query("select u from User u" +
			" where u.id =:id ")
	User findOneUser(@Param("id") Long id);


}
