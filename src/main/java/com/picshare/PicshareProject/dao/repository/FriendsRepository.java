package com.picshare.PicshareProject.dao.repository;

import com.picshare.PicshareProject.dao.entities.*;

import com.picshare.PicshareProject.dao.entities.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface  FriendsRepository extends JpaRepository<Friends, Long>{

    @Query("SELECT f from Friends f where f.sender=:s and f.receiver =:r")
    Friends getFriendsBySendAndReceiver(@Param(value = "s") User sender, @Param(value = "r") User receiver);

    @Query("SELECT f from Friends f where f.sender=:s or f.receiver=:s and f.status='AMI'")
    Collection<User> getAllFriends(@Param(value = "s") User sender);


    @Query("SELECT f from Friends f where f.sender=:s and f.status=:status")
    Collection<User> getAllFriendsByStatus(@Param(value = "s") User sender, @Param(value = "status") String  status);

    @Query("SELECT f from Friends f where f.receiver=:r and f.status=:status")
    Collection<User> getAllReceivedRequest(@Param(value = "r") User sender, @Param(value = "status") String  status);

}
