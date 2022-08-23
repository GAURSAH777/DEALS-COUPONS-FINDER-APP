package com.jwt.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.model.CustomerUser;
import com.jwt.repository.CustomerUserRepository;

@Service
public class CustomerUserService implements UserDetailsService {

	@Autowired
	private CustomerUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomerUser userfound = userRepository.findByUsername(username);
		if (userfound == null) {
			return null;
		}

		String name = userfound.getUsername();
		String pswd = userfound.getPassword();
		
		List<GrantedAuthority> authorities = Arrays.stream(userfound.getUsername().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());// list of granted Authorities of a user

		// fetching each role of user from DB and storing them individually in list

		return new User(name, pswd, authorities);
	}

}
