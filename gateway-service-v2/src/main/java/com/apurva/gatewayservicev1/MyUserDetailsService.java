package com.apurva.gatewayservicev1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmailString(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Incorrect username or password");
		}
		else {
			return new org.springframework.security.core.userdetails.User(user.getEmailString(), user.getPasswordString(), new ArrayList<>());
		}
	}
	
}
