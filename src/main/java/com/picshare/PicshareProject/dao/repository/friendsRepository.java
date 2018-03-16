package com.picshare.PicshareProject.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.picshare.PicshareProject.dao.entities.Friends;

@Repository
public interface friendsRepository extends JpaRepository<Friends, Long> {

	@Query("SELECT f FROM friends f WHERE f.sender =:sender and f.receiver =:receiver")
	public Friends findBySendAndReceiver(@Param("sender") Long sender, @Param("receiver") Long receiver);
}
