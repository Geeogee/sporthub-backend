package com.sporthub.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.sporthub.backend.model.Playground;

public interface PlaygroundRepository extends CrudRepository<Playground, Integer> {

}
