package com.picshare.PicshareProject.dao.entities;

import java.io.Serializable;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

import java.util.Set;


@Entity
@Table(name = "user")
public class User implements Serializable{
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String firstname;

    @NotEmpty
    @Column(nullable = false)
    private String lastname;

    @NotEmpty
    @Column(nullable = false,unique = true)
    private String username;
    
    @NotEmpty
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    
    private String profilePicPath;
    
    private String biographie;

    private Date birthday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role")
    Set<Role> roles;
    
    
    
    @ManyToMany(targetEntity=User.class)
    private Set<Long> follows;
    
    
    
    public User(){
    	
    }
    
   
	public User(String firstname, String lastname, String username, String password, String email,
			String profilePicPath, String biographie, Date birthday, Set<Role> roles, Set<Long> friends,
			Set<Long> follows) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profilePicPath = profilePicPath;
		this.biographie = biographie;
		this.birthday = birthday;
		this.roles = roles;
		this.follows = follows;
	}
	public User(User user) {
		
		this.firstname = user.firstname;
		this.lastname = user.lastname;
		this.username = user.username;
		this.password = user.password;
		this.email = user.email;
		this.profilePicPath = user.profilePicPath;
		this.biographie = user.biographie;
		this.birthday = user.birthday;
		this.roles = user.roles;
		this.follows = user.follows;
	}


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



	public Set getFollows() {
		return follows;
	}

	public void setFollows(Set follows) {
		this.follows = follows;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
    
}
