package com.picshare.PicshareProject.dao.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "photo")
public class Photo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne(targetEntity = User.class)
	private Long owner;

	@ManyToMany(targetEntity = Group.class)
	private Set<Long> grp;

	@ManyToMany(targetEntity = User.class)
	private Set<Long> votedBy;

	@Column(length = 214)
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

	public Set<Long> getGrp() {
		return grp;
	}

	public void setGrp(Set<Long> grp) {
		this.grp = grp;
	}

	public Set<Long> getVotedBy() {
		return votedBy;
	}

	public void setVotedBy(Set<Long> votedBy) {
		this.votedBy = votedBy;
	}

}
