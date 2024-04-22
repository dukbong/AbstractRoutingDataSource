package com.example.masterslave.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.masterslave.dto.ProductDto;
import com.example.masterslave.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productServiceImpl;

	@GetMapping("/getProductList")
	public ResponseEntity<List<ProductDto>> getProductList() {
		return ResponseEntity.ok().body(productServiceImpl.getProductList());
	}

	@PostMapping("/writeProduct")
	public ResponseEntity<ProductDto> writeProduct(@RequestBody ProductDto productDto) {
		return ResponseEntity.ok().body(productServiceImpl.writeProduct(productDto));
	}
}
