package com.review.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.review.model.NewReview;
import com.review.model.Product;
import com.review.model.Review;
import com.review.repository.ReviewRepository;
import com.review.resources.ReviewResource;

@RestController
public class ReviewController {

	
	@Autowired
	private ReviewResource res;
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public Review getByReviewId(@RequestParam("id") String reviewId) {
		return res.getByReviewId(reviewId);
	}
	
	@RequestMapping(value="/product/review", method=RequestMethod.GET)
	public List<Review> getByProductId(@RequestParam("id") String productId) {
		return res.getByProductId(productId);
	}
	
	
	@RequestMapping(value="/add/review", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> addReview(@RequestBody NewReview body, HttpServletRequest request ) {
		String jwtString = request.getHeader("Authorization").substring(7);
		return res.addReview(body, jwtString);
		
	}
	
//	@RequestMapping(value="/test", method=RequestMethod.GET)
//	public Object testMethod(@RequestParam("id") String orderId) {
//		return res.testMethod(orderId);
//	}
	
}
