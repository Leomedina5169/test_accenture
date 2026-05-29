package com.leonelmedina.franchises.presentation.dto.response;

import java.time.Instant;

import com.leonelmedina.franchises.domain.exception.ErrorCode;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

	private final String code;
	private final String message;
	private final Instant timestamp;

	public static ErrorResponse of(ErrorCode errorCode, String message) {
		return ErrorResponse.builder()
				.code(errorCode.name())
				.message(message)
				.timestamp(Instant.now())
				.build();
	}

}
