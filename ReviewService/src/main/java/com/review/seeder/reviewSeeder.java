package com.review.seeder;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.review.model.Review;
import com.review.repository.ReviewRepository;

@Component
public class reviewSeeder implements CommandLineRunner {

	@Autowired
	private ReviewRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		List<Review> seeds = Arrays.asList(
				new Review("12","rutvik","Nice Product",4),
				new Review("12","apurva","good Product",5),
				new Review("12","niketan","mehh Product",1),
				new Review("13","rutvik","Nice ",1),
				new Review("13","apurva","Not a Product",3),
				new Review("14","niketan","Nice Product",2),
				new Review("14","dhyey","Noice",3),
				new Review("15","swapnil","better than mine",5)
				);
		
		repo.saveAll(seeds);
	}

}
