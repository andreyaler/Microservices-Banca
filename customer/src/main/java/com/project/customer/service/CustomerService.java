package com.project.customer.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.customer.model.Customer;
import com.project.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Flux<Customer> findAll() {
		log.debug("");
		return customerRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Customer> findById(final String id) {
		log.info("id : " + id);
		return customerRepository.findById(id);
	}

	public Mono update(final String id, final Customer customer) {
		return customerRepository.save(customer);
	}

	public Mono create(final Customer customer) {
		return customerRepository.save(customer);
	}

	public Mono delete(final String id) {
		final Mono<Customer> dbCustomer = findById(id);
		
		if (Objects.isNull(dbCustomer)) {
			return Mono.empty();
		}
		
		return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(customerToBeDeleted -> customerRepository.delete(customerToBeDeleted)
						.then(Mono.just(customerToBeDeleted)));
	}
}