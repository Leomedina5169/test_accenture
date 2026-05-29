package com.leonelmedina.franchises.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BranchResponse {

	private final Long id;
	private final Long franchiseId;
	private final String name;

}
