package com.financeiro.financeiro.repositories;


import com.financeiro.financeiro.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
