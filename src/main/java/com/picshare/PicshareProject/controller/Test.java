package com.picshare.PicshareProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Test {

	@GetMapping(path = "/hello")
	private String insert() {
		return "Hello je suis admin";
	}
}
