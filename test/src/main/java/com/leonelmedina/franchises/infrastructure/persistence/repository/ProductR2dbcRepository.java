package com.leonelmedina.franchises.infrastructure.persistence.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.leonelmedina.franchises.infrastructure.persistence.entity.BranchMaxStockRow;
import com.leonelmedina.franchises.infrastructure.persistence.entity.ProductEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductR2dbcRepository extends ReactiveCrudRepository<ProductEntity, Long> {

	Mono<Boolean> existsByIdAndBranchId(Long id, Long branchId);

	@Query("""
			SELECT b.id AS branch_id, b.name AS branch_name, p.id AS product_id,
			       p.name AS product_name, p.stock AS stock
			FROM branch b
			INNER JOIN product p ON p.branch_id = b.id
			INNER JOIN (
			    SELECT branch_id, MAX(stock) AS max_stock FROM product GROUP BY branch_id
			) mx ON mx.branch_id = b.id AND p.stock = mx.max_stock
			WHERE b.franchise_id = :franchiseId
			""")
	Flux<BranchMaxStockRow> findMaxStockByFranchiseId(Long franchiseId);

}
