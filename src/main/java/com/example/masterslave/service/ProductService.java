package com.example.masterslave.service;

import java.util.List;

import com.example.masterslave.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> getProductList();
	
	ProductDto writeProduct(ProductDto productDto);
	
}
