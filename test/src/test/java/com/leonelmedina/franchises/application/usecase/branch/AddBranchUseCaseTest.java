package com.leonelmedina.franchises.application.usecase.branch;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.domain.port.BranchRepository;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class AddBranchUseCaseTest {

	@Mock
	private FranchiseRepository franchiseRepository;

	@Mock
	private BranchRepository branchRepository;

	@InjectMocks
	private AddBranchUseCase addBranchUseCase;

	@Test
	void shouldFailWhenFranchiseNotFound() {
		Branch branch = Branch.builder().franchiseId(99L).name("Sucursal").build();
		when(franchiseRepository.existsById(99L)).thenReturn(Mono.just(false));

		StepVerifier.create(addBranchUseCase.execute(branch))
				.expectErrorMatches(ex -> ex instanceof ResourceNotFoundException
						&& ((ResourceNotFoundException) ex).getErrorCode() == ErrorCode.FRANCHISE_NOT_FOUND)
				.verify();
	}

}
