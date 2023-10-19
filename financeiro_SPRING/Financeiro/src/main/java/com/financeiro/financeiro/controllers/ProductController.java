package com.financeiro.financeiro.controllers;

import com.financeiro.financeiro.domain.product.Product;
import com.financeiro.financeiro.domain.product.ProductRequestDTO;
import com.financeiro.financeiro.domain.product.ProductResponseDTO;
import com.financeiro.financeiro.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity<Void> postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);
        this.repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
    

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return ResponseEntity.ok(productList);
    }
    
}
