package com.leonelmedina.franchises.presentation.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonelmedina.franchises.application.usecase.franchise.CreateFranchiseUseCase;
import com.leonelmedina.franchises.application.usecase.franchise.GetAllFranchisesUseCase;
import com.leonelmedina.franchises.application.usecase.franchise.UpdateFranchiseNameUseCase;
import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.presentation.dto.request.NameRequest;
import com.leonelmedina.franchises.presentation.dto.response.FranchiseResponse;
import com.leonelmedina.franchises.presentation.mapper.ResponseMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicias")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Franquicias")
public class FranchiseHandler {

	private final CreateFranchiseUseCase createFranchiseUseCase;
	private final GetAllFranchisesUseCase getAllFranchisesUseCase;
	private final UpdateFranchiseNameUseCase updateFranchiseNameUseCase;

	@GetMapping
	@Operation(summary = "Listar franquicias")
	public Flux<FranchiseResponse> findAll() {
		return getAllFranchisesUseCase.execute().map(ResponseMapper::toResponse);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Crear franquicia")
	public Mono<FranchiseResponse> create(@Valid @RequestBody NameRequest request) {
		Franchise franchise = Franchise.builder().name(request.getName()).build();
		return createFranchiseUseCase.execute(franchise).map(ResponseMapper::toResponse);
	}

	@PatchMapping("/{franquiciaId}/nombre")
	@Operation(summary = "Actualizar nombre de franquicia")
	public Mono<FranchiseResponse> updateName(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Valid @RequestBody NameRequest request) {
		return updateFranchiseNameUseCase.execute(franquiciaId, request.getName()).map(ResponseMapper::toResponse);
	}

}
