package com.leonelmedina.franchises.presentation.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequest {

	@Min(0)
	private int stock;

}
