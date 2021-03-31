package com.apurva.gatewayservicev1;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByEmailString(String emailString);
}
