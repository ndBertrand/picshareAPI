package com.picshare.PicshareProject.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String name;

	private String description;

	@NotNull
	@ManyToOne(targetEntity = User.class)
	private Long creator;

	@ManyToMany(targetEntity = User.class)
	private Set<Long> members;

	@CreatedDate
	private Date createdDate;

	public Group() {

	}

	public Group(Long id, String name, String description, Long creator, Set<Long> members, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.members = members;
		this.createdDate = createdDate;
	}

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

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUser_createdDate() {
		return createdDate;
	}

	public void setUser_createdDate(Date user_createdDate) {
		this.createdDate = user_createdDate;
	}

	public Set<Long> getMembers() {
		return members;
	}

	public void setMembers(Set<Long> members) {
		this.members = members;
	}

}
