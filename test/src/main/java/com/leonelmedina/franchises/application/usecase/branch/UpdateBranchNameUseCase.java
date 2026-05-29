package com.leonelmedina.franchises.application.usecase.branch;

import org.springframework.stereotype.Service;

import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.exception.ResourceNotFoundException;
import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.domain.port.BranchRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateBranchNameUseCase {

	private final BranchRepository branchRepository;

	public Mono<Branch> execute(Long branchId, Long franchiseId, String name) {
		return branchRepository.existsByIdAndFranchiseId(branchId, franchiseId)
				.flatMap(exists -> Boolean.TRUE.equals(exists)
						? branchRepository.updateName(branchId, name)
						: Mono.error(new ResourceNotFoundException(ErrorCode.BRANCH_NOT_FOUND, "Branch not found")));
	}

}
