package com.project.credit.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.credit.model.Credit;
import com.project.credit.service.CreditService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("credit")
@AllArgsConstructor
@RestController
public class CreditController {
	
	@Autowired
	private CreditService creditService;

	@GetMapping
	public Flux<Credit> getAll() {
		log.info("");
		return creditService.findAll();
	}

	@GetMapping("{id}")
	public Mono<Credit> getById(@PathVariable("id") final String id) {
		log.info("");
		return creditService.findById(id);
	}

	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final Credit credit) {
		log.info("");
		return creditService.update(id, credit);
	}

	@PostMapping
	public Mono create(@RequestBody final Credit credit) {
		log.info("");
		return creditService.create(credit);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		log.info("");
		return creditService.delete(id);
	}
}