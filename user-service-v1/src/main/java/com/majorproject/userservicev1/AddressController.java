package com.majorproject.userservicev1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;
	
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
	
	/**
	 * Endpoint to get all Addresses of the user
	 * @param request
	 * @param userIdInteger
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{userIdInteger}/addresses")
	public List<Address> getAddresses(HttpServletRequest request, @PathVariable Integer userIdInteger) throws Exception{
		if(!canAccess(request, userIdInteger)) {
			throw new Exception("Access denied to sensitive information");
		}
		return addressRepository.findAddressByUserUserIdInteger(userIdInteger);
	}
	
	/**
	 * Endpoint to add an address for the user
	 * @param request
	 * @param userIdInteger
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/{userIdInteger}/addresses")
	public String addAddress(HttpServletRequest request ,@PathVariable Integer userIdInteger, @RequestBody Address address) throws Exception{
		
		if(!canAccess(request, userIdInteger)) {
			throw new Exception("Access Denied to sensitive information");
		}
		address.setUser(new User(userIdInteger,"","","", ""));
		addressRepository.save(address);
		return "Address saved";
	}
	
	/**
	 * Endpoint to update a specific address of the user
	 * @param request
	 * @param userIdInteger
	 * @param addressIdInteger
	 * @param address
	 * @return
	 */
	@PutMapping("/{userIdInteger}/addresses/{addressIdInteger}")
	public String updateAddressById(HttpServletRequest request, @PathVariable Integer userIdInteger, @PathVariable Integer addressIdInteger, @RequestBody Address address) throws Exception{
		if(!canAccess(request, userIdInteger)) {
			throw new Exception("Access Denied to sensitive information");
		}
		address.setUser(new User(userIdInteger,"","","", ""));
		address.setAddressIdInteger(addressIdInteger);
		addressRepository.save(address);
		return "Address updates successfully!";
	}
	
	/**
	 * Endpoint to delete a specific address
	 * @param request
	 * @param userIdInteger
	 * @param addressIdInteger
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{userIdInteger}/addresses/{addressIdInteger}")
	public String deleteAddressById(HttpServletRequest request, @PathVariable Integer userIdInteger, @PathVariable Integer addressIdInteger) throws Exception {
		if(!canAccess(request, userIdInteger)) {
			throw new Exception("Access Denied to sensitive information");
		}
		addressRepository.deleteById(addressIdInteger);
		return "Address removed";
	}
}
