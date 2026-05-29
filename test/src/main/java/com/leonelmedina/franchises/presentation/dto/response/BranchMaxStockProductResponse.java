package com.leonelmedina.franchises.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BranchMaxStockProductResponse {

	private final Long branchId;
	private final String branchName;
	private final Long productId;
	private final String productName;
	private final int stock;

}
