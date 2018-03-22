package com.picshare.PicshareProject.dao.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

import java.util.List;
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
    


    @JsonIgnore
	@ManyToMany
	@JoinTable(name="user_follows",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="follows_id")
	)
	private List<User> users;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name="user_follows",
			joinColumns=@JoinColumn(name="follows_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<User> follows;


    @JsonIgnore
	@OneToMany(mappedBy = "receiver")
	private List<Friends> friendsList;

    @JsonIgnore
	@OneToMany(mappedBy = "sender")
	private List<Friends> friendsSender;

    
    
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getFollows() {
		return follows;
	}

	public void setFollows(List<User> follows) {
		this.follows = follows;
	}

	public List<Friends> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<Friends> friendsList) {
		this.friendsList = friendsList;
	}

	public List<Friends> getFriendsSender() {
		return friendsSender;
	}

	public void setFriendsSender(List<Friends> friendsSender) {
		this.friendsSender = friendsSender;
	}
}
