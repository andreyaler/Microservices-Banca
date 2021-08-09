package com.project.fixedterm.controller;

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

import com.project.fixedterm.model.FixedTerm;
import com.project.fixedterm.service.FixedTermService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("/customer")
@AllArgsConstructor
@RestController
public class FixedTermController {

	WebClient webclient;
	
	@Autowired
	private FixedTermService fixedTermService;

	@GetMapping
	public Flux<FixedTerm> getAll() {
		log.info("");
		return fixedTermService.findAll();
	}

	@GetMapping("{id}")
	public Mono<FixedTerm> getById(@PathVariable("id") final String id) {
		log.info("Enter the getById method");
		return fixedTermService.findById(id);
	}

	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final FixedTerm fixedTerm) {
		log.info("");
		return fixedTermService.update(id, fixedTerm);
	}

	@PostMapping
	public Mono create(@RequestBody final FixedTerm fixedTerm) {
		log.info("");
		return fixedTermService.create(fixedTerm);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		log.info("");
		return fixedTermService.delete(id);
	}
}