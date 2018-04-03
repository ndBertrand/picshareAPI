package com.picshare.PicshareProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.picshare.PicshareProject.dao.entities.Photo;

import com.picshare.PicshareProject.dao.repository.GroupRepository;
import com.picshare.PicshareProject.dao.repository.PhotoRepository;
import com.picshare.PicshareProject.dao.repository.UserRepository;

import static com.picshare.PicshareProject.security.SecurityConstants.CLIENT_URL;

@CrossOrigin(origins = CLIENT_URL)
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
