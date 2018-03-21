package com.picshare.PicshareProject.business.implement;

import com.picshare.PicshareProject.business.contract.FriendInterface;
import com.picshare.PicshareProject.dao.entities.Friends;
import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FriendImpl implements FriendInterface{

    @Autowired
    FriendsRepository friendsRepository;

    @Override
    public void save(Friends friends) {
        friendsRepository.save(friends);
    }

    @Override
    public void delete(Long id) {
        friendsRepository.delete(id);
    }

    @Override
    public Friends getFriendsBySenderAndReceiver(User sender, User receiver) {
        return friendsRepository.getFriendsBySendAndReceiver(sender,receiver);
    }

    @Override
    public Collection<User> getAllFriends(User user) {
        return friendsRepository.getAllFriends(user);
    }

    @Override
    public Collection<User> getAllSentWaitingRequest(User user, String status) {
        return friendsRepository.getAllFriendsByStatus(user, status);
    }

    @Override
    public Collection<User> getAllReceivedWaitingRequest(User user, String status) {
        return friendsRepository.getAllReceivedRequest(user, status);
    }
}
