package com.majorproject.userservicev1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/{userIdInteger}/addresses")
	public List<Address> getAddresses(@PathVariable Integer userIdInteger){
		return addressRepository.findAddressByUserUserIdInteger(userIdInteger);
	}
	
	@PostMapping("/{userIdInteger}/addresses")
	public String addAddress(@PathVariable Integer userIdInteger, @RequestBody Address address) {
		address.setUser(new User(userIdInteger,"","","", ""));
		addressRepository.save(address);
		return "Address saved";
	}
}
