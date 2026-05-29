package com.leonelmedina.franchises.application.usecase.branch;

import org.springframework.stereotype.Service;

import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.domain.port.BranchRepository;
import com.leonelmedina.franchises.domain.port.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddBranchUseCase {

	private final FranchiseRepository franchiseRepository;
	private final BranchRepository branchRepository;

	public Mono<Branch> execute(Branch branch) {
		return franchiseRepository.existsById(branch.getFranchiseId())
				.flatMap(exists -> Boolean.TRUE.equals(exists)
						? branchRepository.save(branch)
						: Mono.error(new ResourceNotFoundException(ErrorCode.FRANCHISE_NOT_FOUND, "Franchise not found")));
	}

}
