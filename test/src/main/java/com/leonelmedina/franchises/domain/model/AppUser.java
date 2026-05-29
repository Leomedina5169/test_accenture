package com.leonelmedina.franchises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AppUser {

	private final Long id;
	private final String username;
	private final String password;
	private final String role;

}
