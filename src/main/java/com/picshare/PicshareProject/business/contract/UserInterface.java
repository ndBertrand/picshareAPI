package com.picshare.PicshareProject.business.contract;

import java.util.Collection;
import java.util.Optional;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.User;

public interface UserInterface {

	void addUser(User user);

	void deleteUser(Long id);

	void updateUser(Long id, User user);

	Collection<User> getAllUsers();

	User getUserById(Long id);

	Optional<User> getUserByUsername(String username);

	User getUserByEmail(String email);

	void follow(Long follower,Long followed);

	void unFollow(Long user,Long followedUser);

	Collection<User> getAllFollowers(Long user);

	Collection<User> getAllFollows(Long user);

	void addOwnGroup(Long owner, Group groupe);

	void joinGroup(Long members, Group groupe);

	void quiteGroup(Long member, Group groupe);

	void addPhoto();

	void addComment();

	void sendFriendRequest(Long sender,Long receiver);

	void acceptFriendRequest(Long sender,Long receiver);

    void refuseFriendRequest(Long sender,Long receiver);

    Collection<User> getAllFriends(Long user);

    Collection<User> getAllSentWaitingRequest(Long user, String status);

    Collection<User> getAllReceiveddWaitingRequest(Long user, String status);

}
