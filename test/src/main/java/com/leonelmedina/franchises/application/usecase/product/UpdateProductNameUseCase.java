package com.leonelmedina.franchises.application.usecase.product;

import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.domain.port.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateProductNameUseCase {

	private final ProductRepository productRepository;

	public Mono<Product> execute(Long productId, Long branchId, String name) {
		return productRepository.existsByIdAndBranchId(productId, branchId)
				.flatMap(exists -> Boolean.TRUE.equals(exists)
						? productRepository.updateName(productId, name)
						: Mono.error(new ResourceNotFoundException(ErrorCode.PRODUCT_NOT_FOUND, "Product not found")));
	}

}
