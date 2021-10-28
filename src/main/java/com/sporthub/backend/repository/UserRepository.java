package com.sporthub.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.sporthub.backend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
