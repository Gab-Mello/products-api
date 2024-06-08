package com.example.products_api.controller;

import com.example.products_api.dto.ProductDto;
import com.example.products_api.model.Product;
import com.example.products_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto productDto){
        ProductDto product = productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProductByUUID(@PathVariable String id){
        ProductDto product = productService.getProductByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable String id, @Valid @RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id,productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
