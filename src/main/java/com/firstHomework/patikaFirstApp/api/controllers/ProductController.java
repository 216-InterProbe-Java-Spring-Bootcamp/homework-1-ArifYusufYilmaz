package com.firstHomework.patikaFirstApp.api.controllers;

import com.firstHomework.patikaFirstApp.business.abstracts.ProductService;
import com.firstHomework.patikaFirstApp.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(name="/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }
    @GetMapping("/lessthan/{expiryDate}")
    public List<Product> findAllByExpiryDateLessThan(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date expiryDate){
        return this.productService.getAllProductsByExpiryDateLessThan(expiryDate);
    }
    @GetMapping("/greater/{expiryDate}")
    public List<Product> findAllByExpiryDateGreaterThan(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date expiryDate){
        return this.productService.getAllProductsByExpiryDateGreaterThan(expiryDate);
    }
}
