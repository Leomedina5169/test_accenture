package com.leonelmedina.franchises.infrastructure.persistence.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.leonelmedina.franchises.infrastructure.persistence.entity.BranchEntity;

import reactor.core.publisher.Mono;

public interface BranchR2dbcRepository extends ReactiveCrudRepository<BranchEntity, Long> {

	Mono<Boolean> existsByIdAndFranchiseId(Long id, Long franchiseId);

}
