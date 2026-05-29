package com.leonelmedina.franchises.domain.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	FRANCHISE_NOT_FOUND(HttpStatus.NOT_FOUND),
	BRANCH_NOT_FOUND(HttpStatus.NOT_FOUND),
	PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND),
	INVALID_STOCK(HttpStatus.BAD_REQUEST),
	INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED),
	VALIDATION_ERROR(HttpStatus.BAD_REQUEST),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED),
	INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

	private final HttpStatus httpStatus;

}
