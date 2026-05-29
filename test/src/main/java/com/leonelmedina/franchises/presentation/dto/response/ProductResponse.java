package com.leonelmedina.franchises.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {

	private final Long id;
	private final Long branchId;
	private final String name;
	private final int stock;

}
