package com.leonelmedina.franchises.application.usecase.product;

import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.BranchMaxStockProduct;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;
import com.leonelmedina.franchises.domain.port.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetMaxStockProductsByFranchiseUseCase {

	private final FranchiseRepository franchiseRepository;
	private final ProductRepository productRepository;

	public Flux<BranchMaxStockProduct> execute(Long franchiseId) {
		return franchiseRepository.existsById(franchiseId)
				.flatMapMany(exists -> Boolean.TRUE.equals(exists)
						? productRepository.findMaxStockProductPerBranchByFranchiseId(franchiseId)
						: Flux.error(new ResourceNotFoundException(ErrorCode.FRANCHISE_NOT_FOUND, "Franchise not found")));
	}

}
