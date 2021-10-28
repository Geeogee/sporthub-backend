package com.sporthub.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.sporthub.backend.model.Rental;

public interface RentalRepository extends CrudRepository<Rental, Integer> {

}
