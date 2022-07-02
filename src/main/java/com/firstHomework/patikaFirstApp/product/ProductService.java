package com.firstHomework.patikaFirstApp.product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();
   // List<Product> findAllByExpiryDate(Date expiryDate);
    List<Product> getAllProductsByExpiryDateLessThan(Date expiryDate);
    List<Product> getAllProductsByExpiryDateGreaterThanOrExpiryDateIsNull(Date expiryDate);

}
