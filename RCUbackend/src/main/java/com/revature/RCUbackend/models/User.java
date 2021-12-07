package com.revature.RCUbackend.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_id_seq")
	@Column(name="id", columnDefinition="int")
	@SequenceGenerator(name="address_id_seq", sequenceName="address_id_seq",  allocationSize=1)
	private int user_id;

	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	private String email;

	private String username;

	private String password;

	private String phone_number;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))

	private Set<Role> roles = new HashSet<>();

	// Constructors here
	public User() {
	}

	public User(int user_id, String first_name, String last_name, String email, String username, String password,
				String phone_number, Set<Role> roles) {
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		this.roles = roles;
	}

	// Getters and Setters
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	// Override the to string method here

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", first_name='" + first_name + '\'' +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", phone_number='" + phone_number + '\'' +
				'}';
	}

}