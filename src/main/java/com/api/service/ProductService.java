package com.api.service;

import com.api.entity.Product;
import com.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public Iterable<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return (Product)repository.findById(id).orElse(null);
    }

    public void deleteProduct(int id)
    {
        repository.deleteById(id);
    }

    public void updateProduct(Product product){
        Product existingProduct= (Product) repository.findById(product.getId()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        repository.save(existingProduct);

    }

}
