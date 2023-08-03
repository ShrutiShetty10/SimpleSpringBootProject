package com.api.controller;

import com.api.entity.Product;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private Environment environment;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.saveProduct(product);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + product.getId();
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public Iterable<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }


}
