package com.leonelmedina.franchises.application.usecase.product;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.leonelmedina.franchises.domain.exception.BusinessException;
import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.port.ProductRepository;

import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class UpdateProductStockUseCaseTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private UpdateProductStockUseCase updateProductStockUseCase;

	@Test
	void shouldFailWhenStockIsNegative() {
		StepVerifier.create(updateProductStockUseCase.execute(1L, 1L, -1))
				.expectErrorMatches(ex -> ex instanceof BusinessException
						&& ((BusinessException) ex).getErrorCode() == ErrorCode.INVALID_STOCK)
				.verify();
	}

}
