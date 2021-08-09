package com.project.accountcurrent.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.accountcurrent.model.AccountCurrent;
import com.project.accountcurrent.repository.AccountCurrentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AccountCurrentService {

	@Autowired
	private AccountCurrentRepository accountRepository;

	public Flux<AccountCurrent> findAll() {
		log.debug("");
		return accountRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<AccountCurrent> findById(final String id) {
		return accountRepository.findById(id);
	}

	public Mono update(final String id, final AccountCurrent accounts) {
		return accountRepository.save(accounts);
	}

	public Mono create(final AccountCurrent accounts) {
		return accountRepository.save(accounts);
	}

	public Mono delete(final String id) {
		final Mono<AccountCurrent> dbAccountCurrent = findById(id);
		if (Objects.isNull(dbAccountCurrent)) {
			return Mono.empty();
		}
		return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(savingsAccounts -> accountRepository.delete(savingsAccounts)
						.then(Mono.just(savingsAccounts)));
	}
}