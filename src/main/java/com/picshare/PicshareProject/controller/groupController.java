package com.picshare.PicshareProject.controller;

import java.util.Collection;

import com.picshare.PicshareProject.business.contract.GroupInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.repository.GroupRepository;
import com.picshare.PicshareProject.dao.repository.UserRepository;

@RequestMapping(path="/group")
@RestController
public class groupController {
	
	@Autowired
    GroupInterface groupeInterface;
	
	@Autowired
	UserRepository UserRepository;
	
	

    @GetMapping(path = "/all")
    public @ResponseBody
    Collection<Group> getAll() {
        return groupeInterface.findAllGroup();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody
    Group findOne(@PathVariable Long id){
        return groupeInterface.findOneGroup(id);
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String add(@RequestBody Group newGroup) {
        groupeInterface.createGroup(newGroup);
        return "Saved";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody
    String update(@RequestParam(value = "id") Long id,@RequestBody Group newGroup){
    	newGroup.setId(id);
        groupeInterface.updateGroup(id,newGroup);
        return "updated";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    String deleteOne(@PathVariable Long id){
    	groupeInterface.deleteGroup(id);
        return "Deleted";
    }
    

   


}
