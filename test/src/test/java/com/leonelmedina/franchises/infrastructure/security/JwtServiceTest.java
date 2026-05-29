package com.leonelmedina.franchises.infrastructure.security;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtServiceTest {

	@Test
	void shouldGenerateValidToken() {
		JwtService jwtService = new JwtService("franchises-local-secret-key-min-32-chars!!", 3600000);
		String token = jwtService.generateToken("admin");
		assertTrue(jwtService.isValid(token));
	}

}
