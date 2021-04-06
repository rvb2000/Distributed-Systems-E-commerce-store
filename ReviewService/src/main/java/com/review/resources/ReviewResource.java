package com.review.resources;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.review.model.NewReview;
import com.review.model.Review;
import com.review.repository.ReviewRepository;

@Service
public class ReviewResource {

	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	public Review getByReviewId( String reviewId) {
		return repo.findByReviewId(reviewId);
	}
	
	public List<Review> getByProductId(String productId) {
		return repo.findByProductId(productId);
	}
	
	public ResponseEntity<Object> addReview(NewReview body, String jwtString) {
		try {
			if(body.isValid()) {
				String reviewerName = jwtUtil.getFullName(jwtString);
				Review nReview = new Review();
				nReview.setProductId(body.getProductId());
				nReview.setRating(body.getRating());
				nReview.setReviewerName(reviewerName);
				nReview.setReviewText(body.getReviewText());
				
				
				Object temp = repo.save(nReview);
				return ResponseEntity.ok(temp);
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'message':'Bad Request'}");
		}
		
	}
}
