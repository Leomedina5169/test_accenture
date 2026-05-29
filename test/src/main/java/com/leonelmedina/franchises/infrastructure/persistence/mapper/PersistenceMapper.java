package com.leonelmedina.franchises.infrastructure.persistence.mapper;

import com.leonelmedina.franchises.domain.model.AppUser;
import com.leonelmedina.franchises.domain.model.Branch;
import com.leonelmedina.franchises.domain.model.BranchMaxStockProduct;
import com.leonelmedina.franchises.domain.model.Franchise;
import com.leonelmedina.franchises.domain.model.Product;
import com.leonelmedina.franchises.infrastructure.persistence.entity.AppUserEntity;
import com.leonelmedina.franchises.infrastructure.persistence.entity.BranchEntity;
import com.leonelmedina.franchises.infrastructure.persistence.entity.BranchMaxStockRow;
import com.leonelmedina.franchises.infrastructure.persistence.entity.FranchiseEntity;
import com.leonelmedina.franchises.infrastructure.persistence.entity.ProductEntity;

public final class PersistenceMapper {

	private PersistenceMapper() {
	}

	public static AppUser toDomain(AppUserEntity entity) {
		return AppUser.builder()
				.id(entity.getId())
				.username(entity.getUsername())
				.password(entity.getPassword())
				.role(entity.getRole())
				.build();
	}

	public static Franchise toDomain(FranchiseEntity entity) {
		return Franchise.builder()
				.id(entity.getId())
				.name(entity.getName())
				.build();
	}

	public static FranchiseEntity toEntity(Franchise franchise) {
		return FranchiseEntity.builder()
				.id(franchise.getId())
				.name(franchise.getName())
				.build();
	}

	public static Branch toDomain(BranchEntity entity) {
		return Branch.builder()
				.id(entity.getId())
				.franchiseId(entity.getFranchiseId())
				.name(entity.getName())
				.build();
	}

	public static BranchEntity toEntity(Branch branch) {
		return BranchEntity.builder()
				.id(branch.getId())
				.franchiseId(branch.getFranchiseId())
				.name(branch.getName())
				.build();
	}

	public static Product toDomain(ProductEntity entity) {
		return Product.builder()
				.id(entity.getId())
				.branchId(entity.getBranchId())
				.name(entity.getName())
				.stock(entity.getStock())
				.build();
	}

	public static ProductEntity toEntity(Product product) {
		return ProductEntity.builder()
				.id(product.getId())
				.branchId(product.getBranchId())
				.name(product.getName())
				.stock(product.getStock())
				.build();
	}

	public static BranchMaxStockProduct toDomain(BranchMaxStockRow row) {
		return BranchMaxStockProduct.builder()
				.branchId(row.getBranchId())
				.branchName(row.getBranchName())
				.productId(row.getProductId())
				.productName(row.getProductName())
				.stock(row.getStock())
				.build();
	}

}
