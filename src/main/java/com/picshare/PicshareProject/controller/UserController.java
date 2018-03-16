package com.picshare.PicshareProject.controller;

import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.UserRepository;
import com.picshare.PicshareProject.metier.UserInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RequestMapping(path="/user")
@RestController
public class UserController{

    @Autowired
    UserInterface userInterface;


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
        return null;
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
    
 

    @PostMapping(path = "/friend_request/{id1}/{id2}")
    public @ResponseBody
    String SendFriendRequest(@PathVariable Long id1,@PathVariable Long id2){
    	userInterface.sendFriendRequest(id1, id2);
        return "request sent";
    }


}
