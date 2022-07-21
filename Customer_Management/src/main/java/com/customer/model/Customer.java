package com.customer.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {
	
	@Id
	private String customerId;

	@NotNull(message = "First name should not be empty")
	@Size(min = 2, message = "First name should not be less than 2 characters")
	private String firstName;

	@NotNull(message = "Last name should not be empty")
	@Size(min = 2, message = "Last name should not be less than 2 characters")
	private String lastName;

	@Pattern(regexp = "\\d{10}", message = "Invalid contact details")
	private String contactNumber;

	@NotNull(message = "Email should not be empty")
	@Email(message = "Invalid E-mail Id")
	private String email;

	@NotNull(message = "Username should not be empty")
	@Size(min = 2, message = "Username should not be less than 2 characters")
	private String username;

	@NotNull(message = "Password should not be empty")
	@Pattern(regexp = " ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain at least one digit [0-9],at least one lowercase Latin character [a-z],"
			+ "at least one uppercase Latin character [A-Z],at least one special character like ! @ # & ( ),"
			+ " a length of at least 8 characters and a maximum of 20 characters")
	private String password;

	
	public Customer() {

	}

	public Customer(String customerId,
			@NotNull(message = "First name should not be empty") @Size(min = 2, message = "First name should not be less than 2 characters") String firstName,
			@NotNull(message = "Last name should not be empty") @Size(min = 2, message = "Last name should not be less than 2 characters") String lastName,
			@Pattern(regexp = "\\d{10}", message = "Invalid contact details") String contactNumber,
			@NotNull(message = "Email should not be empty") @Email(message = "Invalid E-mail Id") String email,
			@NotNull(message = "Username should not be empty") @Size(min = 2, message = "Username should not be less than 2 characters") String username,
			@NotNull(message = "Password should not be empty") @Pattern(regexp = " ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain at least one digit [0-9],at least one lowercase Latin character [a-z],at least one uppercase Latin character [A-Z],at least one special character like ! @ # & ( ), a length of at least 8 characters and a maximum of 20 characters") String password) {
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
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}

}
