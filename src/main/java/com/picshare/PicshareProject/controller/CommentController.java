package com.picshare.PicshareProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picshare.PicshareProject.model.Comment;
import com.picshare.PicshareProject.repository.CommentRepository;


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
