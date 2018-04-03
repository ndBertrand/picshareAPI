package com.picshare.PicshareProject.controller;

import com.picshare.PicshareProject.business.contract.GroupInterface;
import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.Photo;
import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.UserRepository;
import com.picshare.PicshareProject.business.contract.UserInterface;
import static com.picshare.PicshareProject.security.SecurityConstants.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;

@CrossOrigin(origins = CLIENT_URL)
@RequestMapping(path="/user")
@RestController
public class UserController{

    @Autowired
    UserInterface userInterface;
    
    @Autowired
    GroupInterface groupInterface;

    @Autowired
    FileUploadController fileUploadController;


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
    String update(@PathVariable Long id,
                  @RequestBody User newUser){
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
    public @ResponseBody
    Iterable<User> getAllFriends(@RequestParam(value = "user") Long user){
        return userInterface.getAllFriends(user);
    }


    @GetMapping(path="/pendingSentRequest")
    public @ResponseBody
    Iterable<User> getAllPendingSentRequest(@RequestParam(value = "user") Long user){
        return userInterface.getAllSentWaitingRequest(user,"ATTENTE");
    }

    @GetMapping(path="/pendingReceivedRequest")
    public @ResponseBody
    Iterable<User> getAllPendingReceivedRequest(@RequestParam(value = "user") Long user){
       return userInterface.getAllReceiveddWaitingRequest(user,"ATTENTE");
    }

    @PostMapping(path = "/createGroup")
    public @ResponseBody
    String addGroup(@RequestParam(value = "user") Long id, @RequestBody Group groupe){
        userInterface.addOwnGroup(id,groupe);
        return "Saved";
    }

    @PutMapping(path = "/updateGroup")
    public @ResponseBody
    String updateGroup(@RequestParam(value = "user") Long id, @RequestBody Group groupe){
        userInterface.addOwnGroup(id,groupe);
        return "Update";
    }

    @PutMapping(path = "/deleteGroup")
    public @ResponseBody
    String deleteGroup(@RequestParam(value = "user") Long id, @RequestBody Group groupe){
        userInterface.addOwnGroup(id,groupe);
        return "Update";
    }

    @PutMapping(path = "/updateProfilePic")
    public @ResponseBody
    String updateProfilePicture(@RequestParam Long id,@RequestBody MultipartFile file)
    {
        User user = new User();
        user = userInterface.getUserById(id);
        System.out.println(user.getUsername());
        if(user != null) {
            System.out.println("l'utilisateur n'est pas nulle");
            user.setProfilePicPath("" + user.getId() + "/profile/");
            userInterface.updateProfilePicture(file, user.getProfilePicPath());
            userInterface.addUser(user);
        }
        return "Updated";
    }


    @PostMapping(path="/addPhoto")
    public @ResponseBody
    String addPhoto(@RequestParam Long id,@RequestBody Photo photo){

        System.out.println(photo);
//        User user = userInterface.getUserById(id);
//        if(user!= null){
//            Photo newphoto = new Photo();
//            newphoto.setOwner(user.getId());
//            newphoto.setPlace(photo.getPlace());
//            newphoto.setDescription(photo.getDescription());
//            newphoto.setFile(photo.getFile());
//            newphoto.setPath(user.getId()+"/pictures/");
//
//            userInterface.uploadPhoto(newphoto.getFile(),newphoto.getPath());
//
//        }
        return  "photo added";
    }



}
