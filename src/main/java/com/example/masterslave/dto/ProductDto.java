package com.example.masterslave.dto;

import com.example.masterslave.entity.Product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDto {

	private String productName;
	private int productPrice;

	@Builder
	public ProductDto(String productName, int productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product convertEntity() {
		return Product.builder().productName(this.productName).productPrice(this.productPrice).build();
	}

}
