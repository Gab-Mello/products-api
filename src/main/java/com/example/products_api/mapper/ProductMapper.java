package com.example.products_api.mapper;

import com.example.products_api.dto.ProductDto;
import com.example.products_api.model.Product;

public class ProductMapper {

    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        product.setQuantity(productDto.quantity());
        product.setDescription(productDto.description());
        product.setPrice(productDto.price());
        product.setName(productDto.name());
        return product;
    }
}
