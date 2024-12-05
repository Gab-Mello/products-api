# Product Management API 

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## Overview
This project is a **RESTful API for managing products**, developed using **Java** and **Spring Framework**. It provides basic CRUD (Create, Read, Update, Delete) operations for managing product information. The project was created to solidify my understanding of Spring Boot and RESTful API design.

---

## Features
- **Create a Product**: Add new products to the inventory.
- **List Products**: Retrieve a list of all products.
- **Retrieve a Product by ID**: Get detailed information about a specific product.
- **Update a Product**: Modify details of an existing product.
- **Delete a Product**: Remove a product from the inventory.

---

## Technologies Used
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (or any other database, configurable)
- **Maven**

---

## Endpoints

### Products
- **GET /api/products**: Retrieve a list of all products.
- **POST /api/products**: Create a new product.
  - **Request Body**:
    ```json
    {
      "name": "Product Name",
      "description": "Product Description",
      "price": 100.0,
      "quantity": 10
    }
    ```
  - **Response**:
    ```json
    {
      "id": "unique-id",
      "name": "Product Name",
      "description": "Product Description",
      "price": 100.0,
      "quantity": 10
    }
    ```

- **GET /api/products/{id}**: Retrieve a specific product by its ID.
  - **Response**:
    ```json
    {
      "id": "unique-id",
      "name": "Product Name",
      "description": "Product Description",
      "price": 100.0,
      "quantity": 10
    }
    ```

- **PUT /api/products/{id}**: Update an existing product completely.
  - **Request Body**:
    ```json
    {
      "name": "Updated Product Name",
      "description": "Updated Product Description",
      "price": 120.0,
      "quantity": 5
    }
    ```

- **PATCH /api/products/{id}**: Update specific fields of a product.
  - **Request Body Example**:
    ```json
    {
      "price": 130.0
    }
    ```

- **DELETE /api/products/{id}**: Delete a product by its ID.
  - **Response**: `204 No Content`

---
