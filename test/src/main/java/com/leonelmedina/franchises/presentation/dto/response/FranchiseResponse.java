package com.leonelmedina.franchises.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FranchiseResponse {

	private final Long id;
	private final String name;

}
