package com.firstHomework.patikaFirstApp.business.concretes;

import com.firstHomework.patikaFirstApp.business.abstracts.ProductService;
import com.firstHomework.patikaFirstApp.dao.ProductDao;
import com.firstHomework.patikaFirstApp.entities.Product;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
