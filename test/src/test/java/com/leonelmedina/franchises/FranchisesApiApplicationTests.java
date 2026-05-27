package com.leonelmedina.franchises;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.r2dbc.autoconfigure.R2dbcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = R2dbcAutoConfiguration.class)
class FranchisesApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
