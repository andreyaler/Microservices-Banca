package com.project.credit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.credit.model.Credit;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
	
}