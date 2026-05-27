package com.leonelmedina.franchises.application.usecase.product;

import com.leonelmedina.franchises.domain.exception.BusinessException;
import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.domain.port.BranchRepository;
import com.leonelmedina.franchises.domain.port.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddProductUseCase {

	private final BranchRepository branchRepository;
	private final ProductRepository productRepository;

	public Mono<Product> execute(Long franchiseId, Product product) {
		if (product.getStock() < 0) {
			return Mono.error(new BusinessException(ErrorCode.INVALID_STOCK, "Stock must be zero or greater"));
		}
		return branchRepository.existsByIdAndFranchiseId(product.getBranchId(), franchiseId)
				.flatMap(exists -> Boolean.TRUE.equals(exists)
						? productRepository.save(product)
						: Mono.error(new ResourceNotFoundException(ErrorCode.BRANCH_NOT_FOUND, "Branch not found")));
	}

}
