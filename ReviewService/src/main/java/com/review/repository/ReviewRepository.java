package com.review.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.review.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

	public Review findByReviewId(String reviewId);
	public List<Review> findByProductId(String productId);
}
