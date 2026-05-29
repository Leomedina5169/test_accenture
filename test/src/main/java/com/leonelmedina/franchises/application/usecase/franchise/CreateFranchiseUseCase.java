package com.leonelmedina.franchises.application.usecase.franchise;

import org.springframework.stereotype.Service;

import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateFranchiseUseCase {

	private final FranchiseRepository franchiseRepository;

	public Mono<Franchise> execute(Franchise franchise) {
		return franchiseRepository.save(franchise);
	}

}
