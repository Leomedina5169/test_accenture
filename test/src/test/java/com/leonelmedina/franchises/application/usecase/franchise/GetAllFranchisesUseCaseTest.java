package com.leonelmedina.franchises.application.usecase.franchise;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class GetAllFranchisesUseCaseTest {

	@Mock
	private FranchiseRepository franchiseRepository;

	@InjectMocks
	private GetAllFranchisesUseCase getAllFranchisesUseCase;

	@Test
	void shouldReturnAllFranchises() {
		Franchise franchise = Franchise.builder().id(1L).name("Franquicia Norte").build();
		when(franchiseRepository.findAll()).thenReturn(Flux.just(franchise));

		StepVerifier.create(getAllFranchisesUseCase.execute())
				.expectNext(franchise)
				.verifyComplete();
	}

}
