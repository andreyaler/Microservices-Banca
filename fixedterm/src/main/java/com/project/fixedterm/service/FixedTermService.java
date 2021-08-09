package com.project.fixedterm.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.fixedterm.model.FixedTerm;
import com.project.fixedterm.repository.FixedTermRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class FixedTermService {

	@Autowired
	private FixedTermRepository fixedTermRepository;
	
	public Flux<FixedTerm> findAll() {
		log.debug("");
		return fixedTermRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<FixedTerm> findById(final String id) {
		log.info("id : " + id);
		return fixedTermRepository.findById(id);
	}

	public Mono update(final String id, final FixedTerm fixedTerm) {
		return fixedTermRepository.save(fixedTerm);
	}

	public Mono create(final FixedTerm fixedTerm) {
		return fixedTermRepository.save(fixedTerm);
	}

	public Mono delete(final String id) {
		final Mono<FixedTerm> dbFixedTerm = findById(id);
		
		if (Objects.isNull(dbFixedTerm)) {
			return Mono.empty();
		}
		
		return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(fixedTermToBeDeleted -> fixedTermRepository.delete(fixedTermToBeDeleted)
						.then(Mono.just(fixedTermToBeDeleted)));
	}
}