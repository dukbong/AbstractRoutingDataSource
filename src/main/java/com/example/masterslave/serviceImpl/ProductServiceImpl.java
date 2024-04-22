package com.example.masterslave.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.masterslave.dto.ProductDto;
import com.example.masterslave.entity.Product;
import com.example.masterslave.repository.ProductRepository;
import com.example.masterslave.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	@Override
	public List<ProductDto> getProductList() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(Product::convertDto).collect(Collectors.toList());
	}

	@Override
	public ProductDto writeProduct(ProductDto productDto) {
		log.info("name = {}, price = {}", productDto.getProductName(), productDto.getProductPrice());
		Product product = productRepository.save(Product.builder()
				 										.productName(productDto.getProductName())
				 										.productPrice(productDto.getProductPrice())
				 										.build());
		return product.convertDto();
	}

	
}
