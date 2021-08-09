package com.project.accountcurrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountcurrent.model.AccountCurrent;
import com.project.accountcurrent.service.AccountCurrentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("accountcurrent")
@AllArgsConstructor
@RestController
public class AccountCurrentController {

	@Autowired
	private AccountCurrentService accountCurrent;
	
	@GetMapping
	public Flux<AccountCurrent> getAll() {
		log.info("");
		return accountCurrent.findAll();
	}
	
	@GetMapping("{id}")
	public Mono<AccountCurrent> getById(@PathVariable("id") final String id) {
		log.info("");
		return accountCurrent.findById(id);
	}
	
	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final AccountCurrent accounts) {
		log.info("");
		return accountCurrent.update(id, accounts);
	}

	@PostMapping
	public Mono create(@RequestBody final AccountCurrent accounts) {
		log.info("");
		return accountCurrent.create(accounts);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		log.info("");
		return accountCurrent.delete(id);
	}
}