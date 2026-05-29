package com.leonelmedina.franchises.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;

import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;
import com.leonelmedina.franchises.infrastructure.persistence.mapper.PersistenceMapper;
import com.leonelmedina.franchises.infrastructure.persistence.repository.FranchiseR2dbcRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FranchiseRepositoryAdapter implements FranchiseRepository {

	private final FranchiseR2dbcRepository repository;

	@Override
	public Flux<Franchise> findAll() {
		return repository.findAll().map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Franchise> save(Franchise franchise) {
		return repository.save(PersistenceMapper.toEntity(franchise)).map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Franchise> findById(Long franchiseId) {
		return repository.findById(franchiseId).map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Boolean> existsById(Long franchiseId) {
		return repository.existsById(franchiseId);
	}

	@Override
	public Mono<Franchise> updateName(Long franchiseId, String name) {
		return repository.findById(franchiseId)
				.flatMap(entity -> repository.save(entity.toBuilder().name(name).build()))
				.map(PersistenceMapper::toDomain);
	}

}
