package com.leonelmedina.franchises.infrastructure.persistence.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.leonelmedina.franchises.infrastructure.persistence.entity.AppUserEntity;

import reactor.core.publisher.Mono;

public interface AppUserR2dbcRepository extends ReactiveCrudRepository<AppUserEntity, Long> {

	Mono<AppUserEntity> findByUsername(String username);

}
