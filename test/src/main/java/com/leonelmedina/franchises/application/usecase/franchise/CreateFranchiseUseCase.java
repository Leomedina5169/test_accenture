package com.leonelmedina.franchises.application.usecase.franchise;

import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateFranchiseUseCase {

	private final FranchiseRepository franchiseRepository;

	public Mono<Franchise> execute(Franchise franchise) {
		return franchiseRepository.save(franchise);
	}

}
