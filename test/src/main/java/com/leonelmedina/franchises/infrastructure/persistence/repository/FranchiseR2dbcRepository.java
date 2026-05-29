package com.leonelmedina.franchises.infrastructure.persistence.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.leonelmedina.franchises.infrastructure.persistence.entity.FranchiseEntity;

public interface FranchiseR2dbcRepository extends ReactiveCrudRepository<FranchiseEntity, Long> {
}
