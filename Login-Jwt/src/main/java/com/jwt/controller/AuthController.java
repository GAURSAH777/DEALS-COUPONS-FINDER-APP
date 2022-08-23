package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jwt.model.AuthenticationRequest;
import com.jwt.model.AuthenticationResponse;
import com.jwt.model.CustomerUser;
import com.jwt.repository.CustomerUserRepository;
import com.jwt.service.CustomerUserService;
import com.jwt.util.JwtUtil;

@CrossOrigin("*")
@RestController
public class AuthController {

	@Autowired
	private CustomerUserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomerUserService userServices;

	@Autowired
	private JwtUtil jwtUtils;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/dashboard")
	private String testingToken() {
		return "Welcome to DASHBOARD " + SecurityContextHolder.getContext().getAuthentication().getName();
	}

	// to add new user
	@PostMapping("/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
//		String firstname = authenticationRequest.getFirstName();
//		String lastname = authenticationRequest.getLastName();
//		String contact = authenticationRequest.getContactNumber();
		String email = authenticationRequest.getEmail();
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		CustomerUser userModel = new CustomerUser();
//		userModel.setFirstName(firstname);
//		userModel.setLastName(lastname);
//		userModel.setContactNumber(contact);
		userModel.setEmail(email);
		userModel.setUsername(username);
		userModel.setPassword(new BCryptPasswordEncoder().encode(password));

		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			throw new Exception("Invalid", e);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful subscription for client " + username));

	}

//	@PostMapping("/subs")
//	private String subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//		return restTemplate.postForObject("http://customer-service/customer/save", authenticationRequest, String.class);
//	}

	// to authenticate existing user
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			throw new Exception("Invalid", e);

		}
		UserDetails loadeduser = userServices.loadUserByUsername(username);
		String generatedToken = jwtUtils.generateToken(loadeduser);

		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));

	}
}
