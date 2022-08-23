package com.jwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class CustomerUser {

	@Id
	private String customerId;

//	private String firstName;
//
//	private String lastName;
//
//	private String contactNumber;

	private String email;

	private String username;

	private String password;

	public CustomerUser() {

	}

	public CustomerUser(String customerId, String email, String username, String password) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "CustomerUser [customerId=" + customerId + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}

}
