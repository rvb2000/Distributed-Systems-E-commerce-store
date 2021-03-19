package com.majorproject.userservicev1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{userIdInteger}")
	public Optional<User> getUser(@PathVariable Integer userIdInteger) {
		return userRepository.findById(userIdInteger);
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "User added";
	}
}
