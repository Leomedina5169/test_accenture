package com.leonelmedina.franchises.infrastructure.config;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SwaggerRedirectConfig {

	@Bean
	RouterFunction<ServerResponse> swaggerRedirect() {
		return route(GET("/swagger-ui.html"),
				request -> ServerResponse.temporaryRedirect(URI.create("/swagger-ui/index.html")).build());
	}

}
