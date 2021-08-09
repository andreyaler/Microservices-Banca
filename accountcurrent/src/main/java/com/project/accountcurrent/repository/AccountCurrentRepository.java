package com.project.accountcurrent.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.accountcurrent.model.AccountCurrent;

@Repository
public interface AccountCurrentRepository extends ReactiveMongoRepository<AccountCurrent, String> {
	
}