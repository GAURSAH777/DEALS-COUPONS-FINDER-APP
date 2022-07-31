package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.AuthenticationRequest;
import com.jwt.model.AuthenticationResponse;
import com.jwt.model.CustomerUser;
import com.jwt.repository.CustomerUserRepository;
import com.jwt.service.CustomerUserService;
import com.jwt.util.JwtUtil;

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

	@GetMapping("/dashboard")
	private String testingToken() {
		return "Welcome to DASHBOARD " + SecurityContextHolder.getContext().getAuthentication().getName();
	}

	// to add new user
	@PostMapping("/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		String role = authenticationRequest.getRole();
		CustomerUser userModel = new CustomerUser();
		userModel.setUsername(username);
		userModel.setPassword(new BCryptPasswordEncoder().encode(password));
		userModel.setRole(role);
		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			throw new Exception("Invalid", e);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful subscription for client " + username));

	}

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

		return ResponseEntity.ok(new AuthenticationResponse(generatedToken, loadeduser.getAuthorities().toString()));

	}
}
