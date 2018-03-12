package com.picshare.PicshareProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picshare.PicshareProject.model.Group;
import com.picshare.PicshareProject.model.Photo;
import com.picshare.PicshareProject.model.User;
import com.picshare.PicshareProject.repository.GroupRepository;
import com.picshare.PicshareProject.repository.PhotoRepository;
import com.picshare.PicshareProject.repository.UserRepository;

@RestController
@RequestMapping(path = "/photo")
public class PhotoController {
	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	GroupRepository groupRepository;

	@PostMapping(path = "/add")
	private String insert(@RequestBody Photo photo) {
		
		photoRepository.save(photo);
		return "Photo ajoutee";
	}

	@GetMapping(path = "/all")
	private Iterable<Photo> getAll() {
		return photoRepository.findAll();
	}

}
