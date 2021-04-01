package com.apurva.gatewayservicev1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GatewayController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/signup")
	public String register(@RequestBody User user) throws Exception{
		User dupUser = userRepository.findByEmailString(user.getEmailString());
		
		if(dupUser != null) {
			throw new Exception(user.getEmailString() + " is already registerd!");
		}
		
		user.setPasswordString(bCryptPasswordEncoder.encode(user.getPasswordString()));
		userRepository.save(user);
		return "User registered";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "Login Page";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> loginFun(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsernameString(), authenticationRequest.getPasswordString()));
		}
		catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Incorrect username or password", e);
		}
		
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsernameString());
		
		Integer idInteger = userRepository.findByEmailString(authenticationRequest.getUsernameString()).getUserIdInteger();
		
		String jwtString = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwtString));
	}
}
