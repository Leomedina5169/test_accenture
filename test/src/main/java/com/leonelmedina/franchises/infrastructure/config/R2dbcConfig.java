package com.leonelmedina.franchises.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.leonelmedina.franchises.infrastructure.persistence.repository")
public class R2dbcConfig {
}
