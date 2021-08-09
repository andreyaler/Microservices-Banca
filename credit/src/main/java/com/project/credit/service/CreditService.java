package com.project.credit.service;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.credit.model.Credit;
import com.project.credit.repository.CreditRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CreditService {
	
	@Autowired
	private CreditRepository creditRepository;

	public Flux<Credit> findAll() {
		log.debug("");
		return creditRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Credit> findById(final String id) {
		return creditRepository.findById(id);
	}

	public Mono update (final String id, final Credit credit) {
		return creditRepository.save(credit);
	}

	public Mono create (final Credit credit) {
		return creditRepository.save(credit);
	}

	public Mono delete(final String id) {
		final Mono<Credit> dbCredit = findById(id);
		if (Objects.isNull(dbCredit)) {
			return Mono.empty();
		}
		return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(creditToBeDeleted -> creditRepository.delete(creditToBeDeleted)
						.then(Mono.just(creditToBeDeleted)));
	}
}