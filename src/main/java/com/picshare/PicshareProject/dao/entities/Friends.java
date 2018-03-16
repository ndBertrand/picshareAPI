package com.picshare.PicshareProject.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name = "friends")
public class Friends  implements Serializable{
	

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne(targetEntity = User.class)
	private Long sender;
	
	

	@NotEmpty
	@ManyToOne(targetEntity = User.class)
	private Long receiver;
	
	
	@NotEmpty
	private String status;

	public Friends(){
		
	}

	public Friends(Long id, Long sender, Long receiver, String status) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getSender() {
		return sender;
	}


	public void setSender(Long sender) {
		this.sender = sender;
	}


	public Long getReceiver() {
		return receiver;
	}


	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
