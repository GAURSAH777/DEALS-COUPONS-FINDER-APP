package com.customer.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Added Bean Validation
 */
@Document(collection = "customer")
public class Customer {

	@Id
	private String customerId;

//	@NotNull(message = "First name should not be empty")
//	@Size(min = 2, message = "First name should not be less than 2 characters")
//	private String firstName;
//
//	@NotNull(message = "Last name should not be empty")
//	@Size(min = 2, message = "Last name should not be less than 2 characters")
//	private String lastName;
//
//	@Pattern(regexp = "\\d{10}", message = "Invalid contact details")
//	private String contactNumber;

	@NotNull(message = "Email should not be empty")
	@Email(message = "Invalid E-mail Id")
	private String email;

	@NotNull(message = "Username should not be empty")
	@Size(min = 2, message = "Username should not be less than 2 characters")
	private String username;

	@NotNull(message = "Password should not be empty")
//	@Pattern(regexp = " ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Invalid Password")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should contain:\n1)a digit must occur at least once\n 2)a lower case letter must occur at least once\n\r\n 3)an upper case letter must occur at least once\n4)a special character must occur at least once\n\r\n5)no whitespace allowed in the entire string\n6)at least 8 characters")
	private String password;

	public Customer() {

	}

	public Customer(String customerId,
			@NotNull(message = "Email should not be empty") @Email(message = "Invalid E-mail Id") String email,
			@NotNull(message = "Username should not be empty") @Size(min = 2, message = "Username should not be less than 2 characters") String username,
			@NotNull(message = "Password should not be empty") String password) {
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
		return "Customer [customerId=" + customerId + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}

}
