package com.picshare.PicshareProject.business.implement;

import com.picshare.PicshareProject.business.contract.FriendInterface;
import com.picshare.PicshareProject.dao.entities.Friends;
import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<User> allFriends = new ArrayList<User>();

        for(Friends f: friendsRepository.getAllFriends(user) ){
            if(f.getStatus().equalsIgnoreCase("AMI")){
                if(f.getSender().getId() == user.getId())
                    allFriends.add(f.getReceiver());
                else
                    allFriends.add(f.getSender());
            }
        }
        return allFriends;
    }

    @Override
    public Collection<User> getAllSentWaitingRequest(User user, String status) {
        List<User> allFriends = new ArrayList<User>();
        for(Friends f: friendsRepository.findAll()){
            if(f.getStatus().equalsIgnoreCase(status) && f.getSender().getId() == user.getId()){
                    allFriends.add(f.getReceiver());
            }
        }
        return allFriends;
    }

    @Override
    public Collection<User> getAllReceivedWaitingRequest(User user, String status) {
        List<User> allFriends = new ArrayList<User>();
        for(Friends f: friendsRepository.findAll()){
            if(f.getStatus().equalsIgnoreCase(status) && f.getReceiver().getId() == user.getId()){
                allFriends.add(f.getSender());
            }
        }
        return allFriends;
    }
}
