package com.picshare.PicshareProject.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.CrossOrigin;

import static com.picshare.PicshareProject.security.SecurityConstants.CLIENT_URL;

@CrossOrigin(origins = CLIENT_URL)
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(length = 240)
	private String content;

	@NotEmpty
	@ManyToOne(targetEntity = User.class)
	private Long author;

	@NotEmpty
	@ManyToOne(targetEntity = Photo.class)
	private Long photo;

	public Comment() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getPhoto() {
		return photo;
	}

	public void setPhoto(Long photo) {
		this.photo = photo;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public Long getAuthor() {
		return author;
	}

}
