package com.picshare.PicshareProject.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String name;

	private String description;

	@ManyToOne
	private User creator;

	@CreatedDate
	private Date createdDate = new Date();

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getUser_createdDate() {
		return createdDate;
	}

	public void setUser_createdDate(Date user_createdDate) {
		this.createdDate = user_createdDate;
	}

	
}
