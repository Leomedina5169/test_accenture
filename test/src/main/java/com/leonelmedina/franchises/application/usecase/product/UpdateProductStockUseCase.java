package com.leonelmedina.franchises.application.usecase.product;

import com.leonelmedina.franchises.domain.exception.BusinessException;
import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.domain.port.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateProductStockUseCase {

	private final ProductRepository productRepository;

	public Mono<Product> execute(Long productId, Long branchId, int stock) {
		if (stock < 0) {
			return Mono.error(new BusinessException(ErrorCode.INVALID_STOCK, "Stock must be zero or greater"));
		}
		return productRepository.existsByIdAndBranchId(productId, branchId)
				.flatMap(exists -> Boolean.TRUE.equals(exists)
						? productRepository.updateStock(productId, stock)
						: Mono.error(new ResourceNotFoundException(ErrorCode.PRODUCT_NOT_FOUND, "Product not found")));
	}

}
