package com.sporthub.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer review_id;

	@ManyToOne()
	@JoinColumn(name="review_playground")
	private Playground playground;
	
	@ManyToOne()
	@JoinColumn(name="review_user")
	private User user_review;
	
	private Integer rating;
	
	private String review_message;
	
	public Review() {}

	public Integer getReview_id() {
		return review_id;
	}

	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}

	public Playground getPlayground() {
		return playground;
	}

	public void setPlayground(Playground playground) {
		this.playground = playground;
	}

	public User getUser() {
		return user_review;
	}

	public void setUser(User user) {
		this.user_review = user;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview_message() {
		return review_message;
	}

	public void setReview_message(String review_message) {
		this.review_message = review_message;
	}
}
