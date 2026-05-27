package com.leonelmedina.franchises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Branch {

	private final Long id;
	private final Long franchiseId;
	private final String name;

}
