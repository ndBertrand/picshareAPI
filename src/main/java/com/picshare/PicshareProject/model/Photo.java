package com.picshare.PicshareProject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "photo")
public class Photo {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity = User.class)
	private Long owner;
	
	@ManyToMany(targetEntity = Group.class)
	private Set<Long> grp;
	
	private enum visibility{
		PUBLIC, PRIVATE
	}
	
	@Enumerated(EnumType.ORDINAL)
    private visibility visibilite;
	
	
	@Column(length = 214 )
	private String description;
	
	private Date date = new Date();
	
	private String place;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public visibility getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(visibility visibilite) {
		this.visibilite = visibilite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	
	
	
	
	
	

}
