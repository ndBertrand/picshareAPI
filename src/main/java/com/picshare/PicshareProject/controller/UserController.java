package com.picshare.PicshareProject.controller;

import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.UserRepository;
import com.picshare.PicshareProject.business.contract.UserInterface;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path="/user")
@RestController
public class UserController{

    @Autowired
    UserInterface userInterface;
    
    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAll() {
        return userInterface.getAllUsers();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody
    User findOne(@PathVariable Long id){
        return userInterface.getUserById(id);
    }
    @GetMapping(path="/find/")
    public @ResponseBody
    User findByEmail(@RequestParam String email){
        return userInterface.getUserByEmail(email);
    }

    @PostMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String add(@RequestBody User newUser) {
        userInterface.addUser(newUser);
        return "Saved";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody
    String update(@PathVariable Long id,@RequestBody User newUser){
        User user = newUser;
        user.setId(id);
        userInterface.updateUser(id, newUser);
        return "updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    String deleteOne(@PathVariable Long id){
        userInterface.deleteUser(id);
        return "Deleted";
    }
     
    @PostMapping(path= "/follow")
    public String follow(@RequestParam(value = "user") Long user,@RequestParam(value = "follower") Long follower){
    System.out.println(user + " "+follower);
        userInterface.follow(user,follower);
    	return "done";
    }

    @PostMapping(path= "/unfollow")
    public String unFollow(@RequestParam(value = "user") Long user,@RequestParam(value = "follower") Long follower){
        System.out.println(user + " "+follower);
        userInterface.unFollow(user,follower);
        return "done";
    }

    @GetMapping(path = "{id}/followers")
    public @ResponseBody
    Iterable<User> getallFollowers(@PathVariable(value = "id") Long id){
        return userInterface.getAllFollowers(id);
    }

    @GetMapping(path = "{id}/follows")
    public @ResponseBody
    Iterable<User> getAllFollows(@PathVariable(value = "id") Long id){
        return userInterface.getAllFollows(id);
    }

    @PostMapping(path = "/sendRequest")
    public String
    sendFriendRequest(@RequestParam(value = "sender") Long sender,@RequestParam(value = "receiver") Long receiver){
        userInterface.sendFriendRequest(sender,receiver);
        return "done";
    }

    @PutMapping(path = "/acceptRequest")
    public String
    acceptFriendRequest(@RequestParam(value = "sender") Long sender,@RequestParam(value = "receiver") Long receiver){
        userInterface.acceptFriendRequest(sender,receiver);
        return "done";
    }

    @DeleteMapping(path = "/refuseRequest")
    public String
    refuseFriendRequest(@RequestParam(value = "sender") Long sender,@RequestParam(value = "receiver") Long receiver){
        userInterface.refuseFriendRequest(sender,receiver);
        return "done";
    }

    @GetMapping(path="/allFriends")
    public String
    getAllFriends(@RequestParam(value = "sender") Long user){
        return null;
    }



}
