package com.leonelmedina.franchises.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;

import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.domain.port.BranchRepository;
import com.leonelmedina.franchises.infrastructure.persistence.mapper.PersistenceMapper;
import com.leonelmedina.franchises.infrastructure.persistence.repository.BranchR2dbcRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class BranchRepositoryAdapter implements BranchRepository {

	private final BranchR2dbcRepository repository;

	@Override
	public Mono<Branch> save(Branch branch) {
		return repository.save(PersistenceMapper.toEntity(branch)).map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Branch> findById(Long branchId) {
		return repository.findById(branchId).map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Boolean> existsByIdAndFranchiseId(Long branchId, Long franchiseId) {
		return repository.existsByIdAndFranchiseId(branchId, franchiseId);
	}

	@Override
	public Mono<Branch> updateName(Long branchId, String name) {
		return repository.findById(branchId)
				.flatMap(entity -> repository.save(entity.toBuilder().name(name).build()))
				.map(PersistenceMapper::toDomain);
	}

}
