package com.leonelmedina.franchises.presentation.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonelmedina.franchises.application.usecase.auth.AuthenticateUserUseCase;
import com.leonelmedina.franchises.presentation.dto.request.LoginRequest;
import com.leonelmedina.franchises.presentation.dto.response.TokenResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/autenticacion")
@RequiredArgsConstructor
@Tag(name = "Autenticacion")
public class AuthHandler {

	private final AuthenticateUserUseCase authenticateUserUseCase;

	@PostMapping("/iniciar-sesion")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Iniciar sesion")
	public Mono<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
		return authenticateUserUseCase.execute(request.getUsername(), request.getPassword())
				.map(token -> TokenResponse.builder().token(token).build());
	}

}
