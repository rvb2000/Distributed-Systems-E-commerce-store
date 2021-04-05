package com.review.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="reviews")
public class Review {
	
	
	@Id
	private String reviewId;
	private String productId;
	private String reviewerName;
	private String reviewText;
	private int rating;
	
	public Review() {}
	
	public Review(String productId, String reviewerName, String reviewText, int rating) {
		super();
		this.productId = productId;
		this.reviewerName = reviewerName;
		this.reviewText = reviewText;
		this.rating = rating;
	}
	
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
//	public List<String> getImageUris() {
//		return imageUris;
//	}
//	public void setImageUris(List<String> imageUris) {
//		this.imageUris = imageUris;
//	}
	
	
	
	

}
