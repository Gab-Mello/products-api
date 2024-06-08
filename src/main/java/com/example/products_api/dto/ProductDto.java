package com.example.products_api.dto;


public record ProductDto(String id, String name, Double price, String description, Integer quantity) {
}
