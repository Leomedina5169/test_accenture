package com.leonelmedina.franchises.domain.port;

import com.leonelmedina.franchises.domain.model.AppUser;

import reactor.core.publisher.Mono;

public interface AppUserRepository {

	Mono<AppUser> findByUsername(String username);

}
