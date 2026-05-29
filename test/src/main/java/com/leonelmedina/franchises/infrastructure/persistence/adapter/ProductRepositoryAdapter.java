package com.leonelmedina.franchises.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;

import com.leonelmedina.franchises.domain.model.BranchMaxStockProduct;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.domain.port.ProductRepository;
import com.leonelmedina.franchises.infrastructure.persistence.mapper.PersistenceMapper;
import com.leonelmedina.franchises.infrastructure.persistence.repository.ProductR2dbcRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

	private final ProductR2dbcRepository repository;

	@Override
	public Mono<Product> save(Product product) {
		return repository.save(PersistenceMapper.toEntity(product)).map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Product> findById(Long productId) {
		return repository.findById(productId).map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Void> deleteById(Long productId) {
		return repository.deleteById(productId);
	}

	@Override
	public Mono<Boolean> existsByIdAndBranchId(Long productId, Long branchId) {
		return repository.existsByIdAndBranchId(productId, branchId);
	}

	@Override
	public Mono<Product> updateStock(Long productId, int stock) {
		return repository.findById(productId)
				.flatMap(entity -> repository.save(entity.toBuilder().stock(stock).build()))
				.map(PersistenceMapper::toDomain);
	}

	@Override
	public Mono<Product> updateName(Long productId, String name) {
		return repository.findById(productId)
				.flatMap(entity -> repository.save(entity.toBuilder().name(name).build()))
				.map(PersistenceMapper::toDomain);
	}

	@Override
	public Flux<BranchMaxStockProduct> findMaxStockProductPerBranchByFranchiseId(Long franchiseId) {
		return repository.findMaxStockByFranchiseId(franchiseId).map(PersistenceMapper::toDomain);
	}

}
