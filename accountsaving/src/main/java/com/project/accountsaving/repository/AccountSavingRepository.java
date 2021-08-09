package com.project.accountsaving.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.accountsaving.model.AccountSaving;

@Repository
public interface AccountSavingRepository extends ReactiveMongoRepository<AccountSaving, String> {
	
}