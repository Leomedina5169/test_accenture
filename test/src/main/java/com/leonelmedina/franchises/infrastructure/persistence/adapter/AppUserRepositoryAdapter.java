package com.leonelmedina.franchises.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;

import com.leonelmedina.franchises.domain.model.AppUser;
import com.leonelmedina.franchises.domain.port.AppUserRepository;
import com.leonelmedina.franchises.infrastructure.persistence.mapper.PersistenceMapper;
import com.leonelmedina.franchises.infrastructure.persistence.repository.AppUserR2dbcRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AppUserRepositoryAdapter implements AppUserRepository {

	private final AppUserR2dbcRepository repository;

	@Override
	public Mono<AppUser> findByUsername(String username) {
		return repository.findByUsername(username).map(PersistenceMapper::toDomain);
	}

}
