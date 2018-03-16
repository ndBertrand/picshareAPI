package com.picshare.PicshareProject.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.User;


public interface UserInterface {

    public void addUser(User user);
    public void deleteUser(Long id);
    public void updateUser(Long id, User user);
    public Collection<User> getAllUsers();
    public User getUserById(Long id);
    public Optional<User> getUserByUsername(String username);
    
    public void  sendFriendRequest(Long sender,Long receiver);
    
    public void  acceptFriendRequest(Long sender,Long receiver);
    
    public void  refuseFriendRequest(Long sender,Long receiver);
    
    public void followAnotherUser(Long user,Long followedUser);
    
    public void addOwnGroup(Long owner,Group groupe);
    
    public void joinGroup(Long members,Group groupe);
    
    public void addPhoto();
    
    public void addComment();
}
