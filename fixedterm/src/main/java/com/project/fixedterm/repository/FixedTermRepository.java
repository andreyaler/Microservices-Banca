package com.project.fixedterm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.fixedterm.model.FixedTerm;

@Repository
public interface FixedTermRepository extends ReactiveMongoRepository<FixedTerm, String> {
	
}