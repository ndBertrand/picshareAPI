package com.picshare.PicshareProject.business.contract;

import java.util.Collection;
import java.util.Optional;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserInterface {

	/*CRUD ON USER*/
	void addUser(User user);

	void deleteUser(Long id);

	void updateUser(Long id, User user);

	Collection<User> getAllUsers();

	void updateProfilePicture(MultipartFile file,String path);

	/*ACCESSING USER*/

	User getUserById(Long id);

	Optional<User> getUserByUsername(String username);

	User getUserByEmail(String email);

	/**/

	void follow(Long follower,Long followed);

	void unFollow(Long user,Long followedUser);

	Collection<User> getAllFollowers(Long user);

	Collection<User> getAllFollows(Long user);

	/**/

	void addOwnGroup(Long owner, Group groupe);

	void deleteOwnGroup(Long owner, Group groupe);

	void joinGroup(Long members, Group groupe);

	void quiteGroup(Long member, Group groupe);

	/**/

	void uploadPhoto(MultipartFile file,String path);

	void deletePhoto(Long id);

	/**/

	void addComment();


	/**/
	void sendFriendRequest(Long sender,Long receiver);

	void acceptFriendRequest(Long sender,Long receiver);

    void refuseFriendRequest(Long sender,Long receiver);

    Collection<User> getAllFriends(Long user);

    Collection<User> getAllSentWaitingRequest(Long user, String status);

    Collection<User> getAllReceiveddWaitingRequest(Long user, String status);

}
