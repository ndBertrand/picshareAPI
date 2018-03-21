package com.picshare.PicshareProject.business.implement;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import com.picshare.PicshareProject.business.contract.FriendInterface;
import com.picshare.PicshareProject.dao.entities.Friends;
import com.picshare.PicshareProject.dao.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.UserRepository;
import com.picshare.PicshareProject.business.contract.GroupInterface;
import com.picshare.PicshareProject.business.contract.UserInterface;

@Service
public class UserImpl implements UserInterface {

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	GroupInterface groupInterface;

	@Autowired
    FriendInterface friendInterface;

	
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
		return userrepository.getAllUser();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userrepository.findOneUser(id);
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepository.findByUsername(username);
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

	@Override
	public User getUserByEmail(String email) {
		return userrepository.findByEmail(email);
	}

	@Override
	public void follow(Long user,Long follower) {
		// TODO Auto-generated method stub
		User u = userrepository.findOneUser(user);
		u.getFollows().add(userrepository.findOneUser(follower));
		userrepository.save(u);
	}

	@Override
	public void unFollow(Long user,Long follower) {
		User u = userrepository.findOneUser(user);
		u.getFollows().remove(userrepository.findOneUser(follower));
		userrepository.save(u);

	}

	@Override
	public void sendFriendRequest(Long sender,Long receiver){
		User s = userrepository.findOneUser(sender);
		User r = userrepository.findOneUser(receiver);

		Friends newFriends = new Friends();
		newFriends.setSender(s);
		newFriends.setReceiver(r);
		newFriends.setStatus("ATTENTE");

        friendInterface.save(newFriends);
	}

    @Override
    public void acceptFriendRequest(Long sender, Long receiver) {
        User s = userrepository.findOneUser(sender);
        User r = userrepository.findOneUser(receiver);

	    Friends friends = friendInterface.getFriendsBySenderAndReceiver(s,r);
	    friends.setStatus("AMI");


        friendInterface.save(friends);
    }

    @Override
    public void refuseFriendRequest(Long sender, Long receiver) {
        User s = userrepository.findOneUser(sender);
        User r = userrepository.findOneUser(receiver);
        Friends friends = friendInterface.getFriendsBySenderAndReceiver(s,r);
        friendInterface.delete(friends.getId());
    }

    @Override
    public Collection<User> getAllFriends(Long user) {
        User s = userrepository.findOneUser(user);
        return friendInterface.getAllFriends(s);
    }

    @Override
    public Collection<User> getAllSentWaitingRequest(Long user, String status) {
        User s = userrepository.findOneUser(user);
        return friendInterface.getAllSentWaitingRequest(s, status);
    }

    @Override
    public Collection<User> getAllReceidWaitingRequest(Long user, String status) {
        User s = userrepository.findOneUser(user);
        return friendInterface.getAllReceivedWaitingRequest(s, status);
    }

    @Override
	public Collection<User> getAllFollowers(Long user) {
		User u = userrepository.findOneUser(user);
		return u.getUsers();
	}

	@Override
	public Collection<User> getAllFollows(Long user) {
		User u = userrepository.findOneUser(user);
		return u.getFollows();
	}


}
