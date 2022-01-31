package com.learning.service;

import com.learning.entity.Product;

import java.util.List;

public interface ProductService {

    //CREATE
    Product addProduct(com.learning.entity.Product product); //save(entity);

    //READ
    List<Product> getProducts(); //findAll
    List<Product> getProductsByName(String name); //findByName [Query method]
    List<Product> getProductsByPriceAndQuantity(Long price, int quantity); //findByPriceAndQuantity [Query method]
    Product getProductById(Long id); //findByPriceAndQuantity [Query method]

    //UPDATE
    Product updateProduct(Long productId, Product product); //fetch + save

    //DELETE
    Product deleteProduct(Long productId); //deleteById
}
