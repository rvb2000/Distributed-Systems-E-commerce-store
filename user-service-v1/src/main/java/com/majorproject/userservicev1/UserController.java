package com.majorproject.userservicev1;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	/**
	 * The method returns whether a particular resource 
	 * can be accessed by the user or not
	 * @return
	 */
	public boolean canAccess(HttpServletRequest request, Integer userIdInteger) {
		String jwtString = request.getHeader("Authorization").substring(7);
		String emailString = jwtUtil.extractUsername(jwtString);
		Integer idInteger = userRepository.findByEmailString(emailString).getUserIdInteger();
		
		return idInteger.equals(userIdInteger);
	}
	
	@GetMapping("/{userIdInteger}")
	public Optional<User> getUser(HttpServletRequest request ,@PathVariable Integer userIdInteger) throws Exception{
		if(!canAccess(request, userIdInteger)) {
			throw new Exception("Access denied to sensitive information");
		}
		return userRepository.findById(userIdInteger);
	}
}
