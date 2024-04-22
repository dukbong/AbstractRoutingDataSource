package com.example.masterslave.entity;

import com.example.masterslave.dto.ProductDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", initialValue = 1, allocationSize = 50)
public class Product {

	@Id
	@GeneratedValue(generator = "product_seq_gen")
	private Long id;
	
	private String productName;
	
	private int productPrice;
	
	@Builder
	public Product(Long id, String productName, int productPrice) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public ProductDto convertDto() {
		return ProductDto.builder()
						 .productName(this.productName)
						 .productPrice(this.productPrice)
						 .build();
	}
	
}
