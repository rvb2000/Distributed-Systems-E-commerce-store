package com.review.resources;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.review.model.NewReview;
import com.review.model.Product;
import com.review.model.Review;
import com.review.repository.ReviewRepository;

@Service
public class ReviewResource {

	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Review getByReviewId( String reviewId) {
		return repo.findByReviewId(reviewId);
	}
	
	public List<Review> getByProductId(String productId) {
		return repo.findByProductId(productId);
	}
	
	public ResponseEntity<Object> addReview(NewReview body, String jwtString) {
		try {
			if(body.isValid()) {
				
				Product[] product=restTemplate.getForObject("http://order-service/user/"+ Integer.parseInt(jwtUtil.getPayload(jwtString)), Product[].class);
				
				HashSet<String> hs = new HashSet<>();
				for(Product p : product)
					hs.add(""+p.getProductIdInteger());
				
				if(!hs.contains(body.getProductId())) {
					throw new Exception("Product is Not Ordered By the User !!!");
				}
				
				String reviewerName = jwtUtil.getFullName(jwtString);
				Review nReview = new Review();
				nReview.setProductId(body.getProductId());
				nReview.setRating(body.getRating());
				nReview.setReviewerName(reviewerName);
				nReview.setReviewText(body.getReviewText());
				
				
				Object temp = repo.save(nReview);
				return ResponseEntity.ok(temp);
			}else {
				throw new Exception("Request Body is not Valid !!!");
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":" + e.getMessage()+"}");
		}
		
	}
//
//	public Object testMethod(String orderId) {
//		
//		return restTemplate.getForObject("http://orderservice/user/"+ orderId, Object.class);
//	}
}
