package com.firstHomework.patikaFirstApp.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {
    private final ProductDao productDao;

    @Override
    public Product createProduct(Product product) {
        return this.productDao.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
          return  this.productDao.findAll();
    }

    @Override
    public List<Product> getAllProductsByExpiryDateLessThan(Date expiryDate) {
       return this.productDao.findAllByExpiryDateLessThan(expiryDate);
    }

    @Override
    public  List<Product> getAllProductsByExpiryDateGreaterThanOrExpiryDateIsNull(Date expiryDate) {
        return this.productDao.findAllByExpiryDateGreaterThanOrExpiryDateIsNull(expiryDate);
    }
}
