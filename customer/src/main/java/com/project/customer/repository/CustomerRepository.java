package com.project.customer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.project.customer.model.Customer;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
	
}