package com.leonelmedina.franchises.presentation.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonelmedina.franchises.application.usecase.branch.AddBranchUseCase;
import com.leonelmedina.franchises.application.usecase.branch.UpdateBranchNameUseCase;
import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.presentation.dto.request.NameRequest;
import com.leonelmedina.franchises.presentation.dto.response.BranchResponse;
import com.leonelmedina.franchises.presentation.mapper.ResponseMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Sucursales")
public class BranchHandler {

	private final AddBranchUseCase addBranchUseCase;
	private final UpdateBranchNameUseCase updateBranchNameUseCase;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Agregar sucursal a franquicia")
	public Mono<BranchResponse> create(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Valid @RequestBody NameRequest request) {
		Branch branch = Branch.builder().franchiseId(franquiciaId).name(request.getName()).build();
		return addBranchUseCase.execute(branch).map(ResponseMapper::toResponse);
	}

	@PatchMapping("/{sucursalId}/nombre")
	@Operation(summary = "Actualizar nombre de sucursal")
	public Mono<BranchResponse> updateName(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Parameter(description = "ID de la sucursal") @PathVariable Long sucursalId,
			@Valid @RequestBody NameRequest request) {
		return updateBranchNameUseCase.execute(sucursalId, franquiciaId, request.getName()).map(ResponseMapper::toResponse);
	}

}
