package com.leonelmedina.franchises.application.usecase.franchise;

import org.springframework.stereotype.Service;

import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class GetAllFranchisesUseCase {

	private final FranchiseRepository franchiseRepository;

	public Flux<Franchise> execute() {
		return franchiseRepository.findAll();
	}

}
