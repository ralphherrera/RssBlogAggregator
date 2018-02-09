package com.rpcherrera.blogs.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, max=50, message="First name must be at	least 1 character!")
	private String firstname;
	
	@Size(min=2, max=50, message="Last name must be at	least 1 character!")
	private String lastname;
	
	@Email(message="Invalid email format!")
	private String email;
	
	@Size(min=6, message="Password must be at least 6 characters!")
	private String password;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.REMOVE)
	private List<Blog> blogs;
	
	private boolean enabled;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateRegistered;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
}
