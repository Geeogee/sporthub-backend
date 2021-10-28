package com.sporthub.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.sporthub.backend.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
