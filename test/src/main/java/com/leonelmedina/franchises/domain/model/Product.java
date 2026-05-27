package com.leonelmedina.franchises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Product {

	private final Long id;
	private final Long branchId;
	private final String name;
	private final int stock;

}
