package com.example.products_api.service;

import com.example.products_api.dto.ProductDto;
import com.example.products_api.mapper.ProductMapper;
import com.example.products_api.model.Product;
import com.example.products_api.repository.ProductRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public Product createProduct(ProductDto productDto){
        Product product = ProductMapper.toProduct(productDto);
        return this.productRepository.save(product);
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(UUID id, ProductDto productDto){
        Product product = productRepository.getReferenceById(id);
        product = ProductMapper.toProduct(productDto);
        return this.productRepository.save(product);
    }
}
