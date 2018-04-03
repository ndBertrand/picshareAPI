package com.picshare.PicshareProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.picshare.PicshareProject.dao.entities.Comment;
import com.picshare.PicshareProject.dao.repository.CommentRepository;

import static com.picshare.PicshareProject.security.SecurityConstants.CLIENT_URL;


@CrossOrigin(origins = CLIENT_URL)
@RequestMapping(path="/Comment")
@RestController
public class CommentController {
	
	@Autowired
	CommentRepository commentRepostiroy;
	
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Comment> getAll() {
        return commentRepostiroy.findAll();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody
    Comment findOne(@PathVariable Long id){
        return commentRepostiroy.findOne(id);
    }

    @PostMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String add(@RequestBody Comment newGroup) {
    	commentRepostiroy.save(newGroup);
        return "Saved";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody
    String update(@PathVariable Long id,@RequestBody Comment newComment){
        
    	newComment.setId(id);
    	commentRepostiroy.save(newComment);
        return "updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    String deleteOne(@PathVariable Long id){
    	commentRepostiroy.delete(id);
        return "Deleted";
    }

    @GetMapping(path="/update/{id}")
    public @ResponseBody
    String updateOne(@PathVariable Long id){

        return "Updated";
    }

   


}
