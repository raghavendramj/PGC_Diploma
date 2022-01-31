package com.learning.controller;

import com.learning.entity.Product;
import com.learning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

//    @GetMapping
//    public ResponseEntity<List<Product>> getProducts() {
//        ResponseEntity<List<Product>> responseEntity =
//                new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
//        return responseEntity;
//    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        return productService.getProductById(productId);
    }


    @GetMapping("/searchByName/{name}")
    public List<Product> getProductsByName(@PathVariable("name") String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/searchByPriceAndQty")
    public List<Product> getProductByPriceAndQuanity(@RequestParam("price") Long price,
                                                     @RequestParam("quantity") int quantity) {
        return productService.getProductsByPriceAndQuantity(price, quantity);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long productId) {
        return productService.deleteProduct(productId);
    }
}
