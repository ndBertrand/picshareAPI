package com.picshare.PicshareProject.business.contract;

import com.picshare.PicshareProject.dao.entities.Friends;
import com.picshare.PicshareProject.dao.entities.User;

import java.util.Collection;

public interface FriendInterface  {

    public void save(Friends friends);

    public void delete(Long id);

    public Friends getFriendsBySenderAndReceiver(User sender, User receiver);

    public Collection<User> getAllFriends(User user);

    public Collection<User> getAllSentWaitingRequest(User user,String status);

    public Collection<User> getAllReceivedWaitingRequest(User user,String status);
}
