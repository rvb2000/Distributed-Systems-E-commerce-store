package com.review.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NewReview {

	
	private String productId;
	private String reviewerName;
	private String reviewText;
	private int rating;
	//private List<String> imageUris;
	
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
	
	
	
	@Override
	public String toString() {
		return "\nproductId : "+this.productId+"\nReviewerName :  "+this.reviewerName+"\nRating : "+this.rating+"\nReviewText : "+this.reviewText;
	}
	
	public boolean isValid() {
		if(this.productId==null || this.rating<1 || this.rating>5)
		return false;
		else
			return true;
	}
}
