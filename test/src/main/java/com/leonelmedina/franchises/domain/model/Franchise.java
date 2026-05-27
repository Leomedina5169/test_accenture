package com.leonelmedina.franchises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Franchise {

	private final Long id;
	private final String name;

}
