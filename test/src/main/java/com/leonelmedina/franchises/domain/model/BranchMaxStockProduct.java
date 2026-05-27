package com.leonelmedina.franchises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BranchMaxStockProduct {

	private final Long branchId;
	private final String branchName;
	private final Long productId;
	private final String productName;
	private final int stock;

}
