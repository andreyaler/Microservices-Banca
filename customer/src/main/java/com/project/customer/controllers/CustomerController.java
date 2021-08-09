package com.project.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.customer.model.Customer;
import com.project.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("/customer")
@AllArgsConstructor
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public Flux<Customer> getAll() {
		log.info("");
		return customerService.findAll();
	}

	@GetMapping("{id}")
	public Mono<Customer> getById(@PathVariable("id") final String id) {
		log.info("Enter the getById method");
		return customerService.findById(id);
	}

	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final Customer customer) {
		log.info("");
		return customerService.update(id, customer);
	}

	@PostMapping
	public Mono create(@RequestBody final Customer customer) {
		log.info("");
		return customerService.create(customer);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		log.info("");
		return customerService.delete(id);
	}
}