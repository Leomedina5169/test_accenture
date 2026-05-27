package com.leonelmedina.franchises.domain.port;

import com.leonelmedina.franchises.domain.model.Branch;

import reactor.core.publisher.Mono;

public interface BranchRepository {

	Mono<Branch> save(Branch branch);

	Mono<Branch> findById(Long branchId);

	Mono<Boolean> existsByIdAndFranchiseId(Long branchId, Long franchiseId);

	Mono<Branch> updateName(Long branchId, String name);

}
