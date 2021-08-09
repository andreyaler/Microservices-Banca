package com.project.accountsaving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountsaving.model.AccountSaving;
import com.project.accountsaving.service.AccountSavingService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("accountsaving")
@AllArgsConstructor
@RestController
public class AccountSavingController {

	@Autowired
	private AccountSavingService accountSavingService;
	
	@GetMapping
	public Flux<AccountSaving> getAll() {
		log.info("");
		return accountSavingService.findAll();
	}
	
	@GetMapping("{id}")
	public Mono<AccountSaving> getById(@PathVariable("id") final String id) {
		log.info("");
		return accountSavingService.findById(id);
	}
	
	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final AccountSaving accountSaving) {
		log.info("");
		return accountSavingService.update(id, accountSaving);
	}

	@PostMapping
	public Mono create(@RequestBody final AccountSaving accountSaving) {
		log.info("");
		return accountSavingService.create(accountSaving);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		log.info("");
		return accountSavingService.delete(id);
	}
}