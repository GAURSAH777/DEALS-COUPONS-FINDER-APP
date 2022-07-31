package com.jwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class CustomerUser {

	@Id
	private String id;

	private String role;

	private String username;

	private String password;

	public CustomerUser() {

	}

	public CustomerUser(String id, String role, String username, String password) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	@Override
	public String toString() {
		return "CustomerUser [id=" + id + ", role=" + role + ", username=" + username + ", password=" + password + "]";
	}

}
