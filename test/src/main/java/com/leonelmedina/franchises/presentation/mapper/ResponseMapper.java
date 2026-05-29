package com.leonelmedina.franchises.presentation.mapper;

import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.domain.model.BranchMaxStockProduct;
import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.presentation.dto.response.BranchMaxStockProductResponse;
import com.leonelmedina.franchises.presentation.dto.response.BranchResponse;
import com.leonelmedina.franchises.presentation.dto.response.FranchiseResponse;
import com.leonelmedina.franchises.presentation.dto.response.ProductResponse;

public final class ResponseMapper {

	private ResponseMapper() {
	}

	public static FranchiseResponse toResponse(Franchise franchise) {
		return FranchiseResponse.builder()
				.id(franchise.getId())
				.name(franchise.getName())
				.build();
	}

	public static BranchResponse toResponse(Branch branch) {
		return BranchResponse.builder()
				.id(branch.getId())
				.franchiseId(branch.getFranchiseId())
				.name(branch.getName())
				.build();
	}

	public static ProductResponse toResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.branchId(product.getBranchId())
				.name(product.getName())
				.stock(product.getStock())
				.build();
	}

	public static BranchMaxStockProductResponse toResponse(BranchMaxStockProduct item) {
		return BranchMaxStockProductResponse.builder()
				.branchId(item.getBranchId())
				.branchName(item.getBranchName())
				.productId(item.getProductId())
				.productName(item.getProductName())
				.stock(item.getStock())
				.build();
	}

}
