package com.project.accountsaving.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.accountsaving.model.AccountSaving;
import com.project.accountsaving.repository.AccountSavingRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AccountSavingService {

	@Autowired
	private final AccountSavingRepository accountSavingRepository;

	public Flux<AccountSaving> findAll() {
		log.debug("");
		return accountSavingRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<AccountSaving> findById(final String id) {
		return accountSavingRepository.findById(id);
	}

	public Mono update(final String id, final AccountSaving accountSaving) {
		return accountSavingRepository.save(accountSaving);
	}

	public Mono create(final AccountSaving accountSaving) {
		return accountSavingRepository.save(accountSaving);
	}

	public Mono delete(final String id) {
		final Mono<AccountSaving> dbAccountSaving = findById(id);
		if (Objects.isNull(dbAccountSaving)) {
			return Mono.empty();
		}
		return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(accontSavingToBeDeleted -> accountSavingRepository.delete(accontSavingToBeDeleted)
						.then(Mono.just(accontSavingToBeDeleted)));
	}
}