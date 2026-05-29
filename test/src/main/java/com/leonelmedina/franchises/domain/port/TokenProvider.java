package com.leonelmedina.franchises.domain.port;

public interface TokenProvider {

	String generateToken(String username);

}
