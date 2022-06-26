package com.firstHomework.patikaFirstApp.business.abstracts;

import com.firstHomework.patikaFirstApp.entities.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();
   // List<Product> findAllByExpiryDate(Date expiryDate);
    List<Product> getAllProductsByExpiryDateLessThan(Date expiryDate);
    List<Product> getAllProductsByExpiryDateGreaterThan(Date expiryDate);

}
