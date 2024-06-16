package com.example.products_api.service;

import com.example.products_api.dto.ProductDto;
import com.example.products_api.mapper.ProductMapper;
import com.example.products_api.model.Product;
import com.example.products_api.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
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
    ProductRepository productRepository;


    public ProductDto createProduct(ProductDto productDto){
        Product product = ProductMapper.toProduct(productDto);
        return ProductMapper.toProductDto(this.productRepository.save(product));
    }

    public List<ProductDto> listProducts(){
        List<ProductDto> list = ProductMapper.toProductDtoList(productRepository.findAll());
        return list;
    }

    public ProductDto updateProduct(String id, ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setDescription(productDto.description());
            product.setName(productDto.name());
            product.setPrice(productDto.price());
            product.setQuantity(productDto.quantity());
            this.productRepository.save(product);
            return ProductMapper.toProductDto(product);
        }
        else{
            throw new EntityNotFoundException();
        }

    }

    public ProductDto getProductByID(String id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return ProductMapper.toProductDto(product.get());
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    public void delete(String id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            productRepository.delete(product);
        }
        else{
            throw new EntityNotFoundException();
        }
    }
}
