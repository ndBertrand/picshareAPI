package com.picshare.PicshareProject.model;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
   
	public enum status{
		ENABLED,
		DESABLED,
		ACTIVATED
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String firstname;

    @NotEmpty
    @Column(nullable = false)
    private String lastname;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
    
   
    private String profilePicPath;

    
    private String biographie;

    private Date birthday;


    @CreatedDate
    private Date createdDate = new Date();
    
    @UpdateTimestamp
    private Date updatedDate;
    
    @Enumerated(EnumType.ORDINAL)
    private status status;
    
    @OneToMany( targetEntity=Group.class )
    private Set<Group> groups;
    
    @ManyToMany(targetEntity=User.class)
    private Set friends;
    
    @ManyToMany(targetEntity=User.class)
    private Set follows;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthDay) {
		this.birthday = birthDay;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public Set getFriends() {
		return friends;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}

	public Set getFollows() {
		return follows;
	}

	public void setFollows(Set follows) {
		this.follows = follows;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
  
	
    
}
