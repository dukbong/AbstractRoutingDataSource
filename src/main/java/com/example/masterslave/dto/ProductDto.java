package com.example.masterslave.dto;

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
	
}
