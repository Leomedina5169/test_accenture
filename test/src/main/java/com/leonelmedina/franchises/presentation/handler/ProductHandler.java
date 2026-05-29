package com.leonelmedina.franchises.presentation.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonelmedina.franchises.application.usecase.product.AddProductUseCase;
import com.leonelmedina.franchises.application.usecase.product.GetMaxStockProductsByFranchiseUseCase;
import com.leonelmedina.franchises.application.usecase.product.RemoveProductUseCase;
import com.leonelmedina.franchises.application.usecase.product.UpdateProductNameUseCase;
import com.leonelmedina.franchises.application.usecase.product.UpdateProductStockUseCase;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.presentation.dto.request.NameRequest;
import com.leonelmedina.franchises.presentation.dto.request.ProductRequest;
import com.leonelmedina.franchises.presentation.dto.request.StockRequest;
import com.leonelmedina.franchises.presentation.dto.response.BranchMaxStockProductResponse;
import com.leonelmedina.franchises.presentation.dto.response.DeleteProductResponse;
import com.leonelmedina.franchises.presentation.dto.response.ProductResponse;
import com.leonelmedina.franchises.presentation.mapper.ResponseMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Productos")
public class ProductHandler {

	private final AddProductUseCase addProductUseCase;
	private final RemoveProductUseCase removeProductUseCase;
	private final UpdateProductStockUseCase updateProductStockUseCase;
	private final UpdateProductNameUseCase updateProductNameUseCase;
	private final GetMaxStockProductsByFranchiseUseCase getMaxStockProductsByFranchiseUseCase;

	@PostMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Agregar producto a sucursal")
	public Mono<ProductResponse> create(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Parameter(description = "ID de la sucursal") @PathVariable Long sucursalId,
			@Valid @RequestBody ProductRequest request) {
		Product product = Product.builder()
				.branchId(sucursalId)
				.name(request.getName())
				.stock(request.getStock())
				.build();
		return addProductUseCase.execute(franquiciaId, product).map(ResponseMapper::toResponse);
	}

	@DeleteMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Eliminar producto de sucursal")
	public Mono<DeleteProductResponse> delete(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Parameter(description = "ID de la sucursal") @PathVariable Long sucursalId,
			@Parameter(description = "ID del producto") @PathVariable Long productoId) {
		return removeProductUseCase.execute(productoId, sucursalId)
				.thenReturn(DeleteProductResponse.of(productoId));
	}

	@PatchMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/stock")
	@Operation(summary = "Modificar stock de producto")
	public Mono<ProductResponse> updateStock(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Parameter(description = "ID de la sucursal") @PathVariable Long sucursalId,
			@Parameter(description = "ID del producto") @PathVariable Long productoId,
			@Valid @RequestBody StockRequest request) {
		return updateProductStockUseCase.execute(productoId, sucursalId, request.getStock()).map(ResponseMapper::toResponse);
	}

	@PatchMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/nombre")
	@Operation(summary = "Actualizar nombre de producto")
	public Mono<ProductResponse> updateName(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId,
			@Parameter(description = "ID de la sucursal") @PathVariable Long sucursalId,
			@Parameter(description = "ID del producto") @PathVariable Long productoId,
			@Valid @RequestBody NameRequest request) {
		return updateProductNameUseCase.execute(productoId, sucursalId, request.getName()).map(ResponseMapper::toResponse);
	}

	@GetMapping("/api/franquicias/{franquiciaId}/productos/mayor-stock-por-sucursal")
	@Operation(summary = "Producto con mas stock por sucursal")
	public Flux<BranchMaxStockProductResponse> maxStockByBranch(
			@Parameter(description = "ID de la franquicia") @PathVariable Long franquiciaId) {
		return getMaxStockProductsByFranchiseUseCase.execute(franquiciaId).map(ResponseMapper::toResponse);
	}

}
