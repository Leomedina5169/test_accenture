package com.leonelmedina.franchises.domain.port;

import com.leonelmedina.franchises.domain.model.BranchMaxStockProduct;
import com.leonelmedina.franchises.domain.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

	Mono<Product> save(Product product);

	Mono<Product> findById(Long productId);

	Mono<Void> deleteById(Long productId);

	Mono<Boolean> existsByIdAndBranchId(Long productId, Long branchId);

	Mono<Product> updateStock(Long productId, int stock);

	Mono<Product> updateName(Long productId, String name);

	Flux<BranchMaxStockProduct> findMaxStockProductPerBranchByFranchiseId(Long franchiseId);

}
