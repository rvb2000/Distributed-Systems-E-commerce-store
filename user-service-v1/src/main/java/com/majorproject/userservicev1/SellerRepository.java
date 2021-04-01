package com.majorproject.userservicev1;

import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer>{
	public void deleteByUserUserIdInteger(Integer userIdInteger);
}
