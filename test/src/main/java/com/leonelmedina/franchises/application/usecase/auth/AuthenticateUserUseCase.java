package com.leonelmedina.franchises.application.usecase.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leonelmedina.franchises.domain.exception.BusinessException;
import com.leonelmedina.franchises.domain.exception.ErrorCode;
import com.leonelmedina.franchises.domain.port.AppUserRepository;
import com.leonelmedina.franchises.domain.port.TokenProvider;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthenticateUserUseCase {

	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;

	public Mono<String> execute(String username, String password) {
		return appUserRepository.findByUsername(username)
				.filter(user -> passwordEncoder.matches(password, user.getPassword()))
				.map(user -> tokenProvider.generateToken(user.getUsername()))
				.switchIfEmpty(Mono.error(new BusinessException(ErrorCode.INVALID_CREDENTIALS, "Invalid credentials")));
	}

}
