package com.picshare.PicshareProject.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.repository.GroupRepository;
import com.picshare.PicshareProject.dao.repository.UserRepository;

@RequestMapping(path="/group")
@RestController
public class groupController {
	
	@Autowired
	GroupRepository grouperepository;
	
	@Autowired
	UserRepository UserRepository;
	
	

    @GetMapping(path = "/all")
    public @ResponseBody
    Collection<Group> getAll() {
        return grouperepository.findAll();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody
    Group findOne(@PathVariable Long id){
        return grouperepository.findOne(id);
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String add(@RequestBody Group newGroup) {
    	grouperepository.save(newGroup);
        return "Saved";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody
    String update(@PathVariable Long id,@RequestBody Group newGroup){
    	newGroup.setId(id);
        grouperepository.save(newGroup);
        return "updated";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    String deleteOne(@PathVariable Long id){
    	grouperepository.delete(id);
        return "Deleted";
    }
    

   


}
