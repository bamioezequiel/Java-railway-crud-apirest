package com.bamioezequiel.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bamioezequiel.apirest.apirest.Repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bamioezequiel.apirest.apirest.Entities.Product;


@RestController
@RequestMapping("/products")
public class ProductController  {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("The product with the id was not found: " + id));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("The product with the id was not found: " + id));
        
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("The product with the id was not found: " + id));

        productRepository.delete(product);
        return "The product with ID: " + id + " was removed successfully";
    }
    
}
