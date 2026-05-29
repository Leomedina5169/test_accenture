package com.leonelmedina.franchises.application.usecase.franchise;

import org.springframework.stereotype.Service;

import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateFranchiseNameUseCase {

	private final FranchiseRepository franchiseRepository;

	public Mono<Franchise> execute(Long franchiseId, String name) {
		return franchiseRepository.existsById(franchiseId)
				.flatMap(exists -> Boolean.TRUE.equals(exists)
						? franchiseRepository.updateName(franchiseId, name)
						: Mono.error(new ResourceNotFoundException(ErrorCode.FRANCHISE_NOT_FOUND, "Franchise not found")));
	}

}
