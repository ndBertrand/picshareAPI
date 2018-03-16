package com.picshare.PicshareProject.metier.implement;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picshare.PicshareProject.dao.entities.Friends;
import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.UserRepository;
import com.picshare.PicshareProject.dao.repository.friendsRepository;
import com.picshare.PicshareProject.metier.GroupInterface;
import com.picshare.PicshareProject.metier.UserInterface;

@Service
@Transactional
public class UserImpl implements UserInterface {

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	friendsRepository friendsRepository;
	
	@Autowired
	GroupInterface groupInterface;
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userrepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userrepository.delete(id);

	}

	@Override
	public void updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		User u = userrepository.findOne(id);
		user.setId(u.getId());
		userrepository.save(user);

	}

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userrepository.findOne(id);
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepository.findByUsername(username);
	}

	@Override
	public void sendFriendRequest(Long sender,Long receiver) {
		// TODO Auto-generated method stub
		User user1 = userrepository.findOne(sender);
		User user2 = userrepository.findOne(receiver);
		
		//BUG-----------------
		/*
		Friends newFriends = new Friends();
		newFriends.setReceiver;
		newFriends.setSender(user1.getId);
		newFriends.setReceiver(user1.getId());
		newFriends.setStatus("Attente");
		friendsRepository.save(newFriends);*/

	}

	@Override
	public void acceptFriendRequest(Long sender,Long receiver) {
		// TODO Auto-generated method stub
		Friends newFriends = friendsRepository.findBySendAndReceiver(sender, receiver);
		newFriends.setStatus("Accepter");
		friendsRepository.save(newFriends);

	}

	@Override
	public void refuseFriendRequest(Long sender,Long receiver) {
		// TODO Auto-generated method stub
		Friends newFriends = friendsRepository.findBySendAndReceiver(sender, receiver);
		friendsRepository.delete(newFriends);
	}

	@Override
	public void followAnotherUser(Long user,Long followedUser) {
		// TODO Auto-generated method stub
		User u = userrepository.findOne(user);
		u.getFollows().add(followedUser);
		userrepository.save(u);

	}

	@Override
	public void addOwnGroup(Long owner,Group groupe) {
		// TODO Auto-generated method stub
		
		groupe.getMembers().add(owner);
		groupInterface.createGroup(groupe);
		
	}

	@Override
	public void joinGroup(Long members,Group groupe) {
		// TODO Auto-generated method stub
		groupe.getMembers().add(members);
		groupInterface.updateGroup(groupe.getId(), groupe);
		
	}

	@Override
	public void addPhoto() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComment() {
		// TODO Auto-generated method stub

	}

}
