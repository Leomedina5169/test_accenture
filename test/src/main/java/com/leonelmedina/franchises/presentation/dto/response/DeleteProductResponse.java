package com.leonelmedina.franchises.presentation.dto.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteProductResponse {

	private final String message;
	private final Long productId;
	private final Instant timestamp;

	public static DeleteProductResponse of(Long productId) {
		return DeleteProductResponse.builder()
				.message("Producto eliminado correctamente")
				.productId(productId)
				.timestamp(Instant.now())
				.build();
	}

}
