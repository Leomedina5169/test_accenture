package com.leonelmedina.franchises.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameRequest {

	@NotBlank
	private String name;

}
