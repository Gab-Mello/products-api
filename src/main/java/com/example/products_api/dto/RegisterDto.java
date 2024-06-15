package com.example.products_api.dto;

import com.example.products_api.model.User.UserRole;

public record RegisterDto(String username, String password, UserRole role) {
}
