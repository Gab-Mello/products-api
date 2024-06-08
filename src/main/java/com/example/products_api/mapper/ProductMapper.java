package com.example.products_api.mapper;

import com.example.products_api.dto.ProductDto;
import com.example.products_api.model.Product;

import java.util.List;

public class ProductMapper {

    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        product.setQuantity(productDto.quantity());
        product.setDescription(productDto.description());
        product.setPrice(productDto.price());
        product.setName(productDto.name());
        return product;
    }

    public static ProductDto toProductDto(Product product){
        var productDto = new ProductDto(product.getId(),
                                        product.getName(),
                                        product.getPrice(),
                                        product.getDescription(),
                                        product.getQuantity());
        return productDto;

    }

    public static List<ProductDto> toProductDtoList(List<Product> list){
        List<ProductDto> listDto = list.stream().map(ProductMapper::toProductDto).toList();
        return listDto;

    }
}
