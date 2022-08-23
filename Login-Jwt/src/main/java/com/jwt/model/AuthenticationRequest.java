package com.jwt.model;

import org.springframework.data.annotation.Id;

public class AuthenticationRequest {

	@Id
	private String customerId;

	private String firstName;

	private String lastName;

	private String contactNumber;

	private String email;

	private String username;

	private String password;

	public AuthenticationRequest() {

	}

	public AuthenticationRequest(String customerId, String firstName, String lastName, String contactNumber,
			String email, String username, String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
		return "AuthenticationRequest [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}

}
