package com.leonelmedina.franchises.infrastructure.persistence.entity;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchMaxStockRow {

	@Column("branch_id")
	private Long branchId;

	@Column("branch_name")
	private String branchName;

	@Column("product_id")
	private Long productId;

	@Column("product_name")
	private String productName;

	private int stock;

}
