package com.leonelmedina.franchises.application.usecase.franchise;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class CreateFranchiseUseCaseTest {

	@Mock
	private FranchiseRepository franchiseRepository;

	@InjectMocks
	private CreateFranchiseUseCase createFranchiseUseCase;

	@Test
	void shouldCreateFranchise() {
		Franchise input = Franchise.builder().name("Franquicia Test").build();
		Franchise saved = Franchise.builder().id(1L).name("Franquicia Test").build();
		when(franchiseRepository.save(any())).thenReturn(Mono.just(saved));

		StepVerifier.create(createFranchiseUseCase.execute(input))
				.expectNext(saved)
				.verifyComplete();
	}

}
