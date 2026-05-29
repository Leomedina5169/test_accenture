package com.leonelmedina.franchises.domain.port;

import com.leonelmedina.franchises.domain.model.Franchise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {

	Flux<Franchise> findAll();

	Mono<Franchise> save(Franchise franchise);

	Mono<Franchise> findById(Long franchiseId);

	Mono<Boolean> existsById(Long franchiseId);

	Mono<Franchise> updateName(Long franchiseId, String name);

}
