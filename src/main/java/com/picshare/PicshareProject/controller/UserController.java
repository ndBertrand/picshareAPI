package com.picshare.PicshareProject.controller;

import com.picshare.PicshareProject.model.User;
import com.picshare.PicshareProject.repository.UserRepository;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RequestMapping(path="/user")
@RestController
public class UserController{

    @Autowired
    UserRepository userRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody
    User findOne(@PathVariable Long id){
        return userRepository.findOne(id);
    }
    @GetMapping(path="/find/")
    public @ResponseBody
    User findByEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @PostMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String add(@RequestBody User newUser) {
        userRepository.save(newUser);
        return "Saved";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody
    String update(@PathVariable Long id,@RequestBody User newUser){
        User user = newUser;
        user.setId(id);
        user.setUpdatedDate(new Date());
        userRepository.save(user);
        return "updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    String deleteOne(@PathVariable Long id){
        userRepository.delete(id);
        return "Deleted";
    }
    
 

    @GetMapping(path = "/friend_request")
    public @ResponseBody
    String SendFriendRequest(@PathVariable Long id1,@PathVariable Long id2){
        return "request sent";
    }


}
