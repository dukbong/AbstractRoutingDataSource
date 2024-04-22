package com.example.masterslave.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.masterslave.dto.ProductDto;
import com.example.masterslave.entity.Product;
import com.example.masterslave.repository.ProductRepository;
import com.example.masterslave.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
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
		Assert.noNullElements(new Object[] {productDto, productDto.getProductName()}, "ProductDto and its attribute productName cannot be null.");
		Product product = productRepository.save(productDto.convertEntity());
		return product.convertDto();
	}

}
