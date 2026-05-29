package com.leonelmedina.franchises.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

	private final String token;

}
