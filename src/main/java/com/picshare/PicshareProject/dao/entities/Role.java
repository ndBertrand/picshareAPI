package com.picshare.PicshareProject.dao.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.picshare.PicshareProject.security.SecurityConstants.CLIENT_URL;

@CrossOrigin(origins = CLIENT_URL)
@Entity
@Table(name = "role")
public class Role implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String role;

	public Role(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}
