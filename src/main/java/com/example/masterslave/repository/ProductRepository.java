package com.example.masterslave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masterslave.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
