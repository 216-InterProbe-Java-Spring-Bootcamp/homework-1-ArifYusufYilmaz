package com.firstHomework.patikaFirstApp.business.concretes;

import com.firstHomework.patikaFirstApp.business.abstracts.ProductService;
import com.firstHomework.patikaFirstApp.dao.ProductDao;
import com.firstHomework.patikaFirstApp.entities.Product;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
          List<Product> productList =  this.productDao.findAll();
            if(productList.isEmpty()){
                System.out.println("true döndü");
                return null;
            }
        System.out.println("false döndü");
          return productList;
    }

    @Override
    public List<Product> findAllByExpiryDateLessThan(Date expiryDate) {
       return this.productDao.findAllByExpiryDateLessThan(expiryDate);
    }

    @Override
    public  List<Product> findAllByExpiryDateGreaterThan(Date expiryDate) {
        return this.productDao.findAllByExpiryDateGreaterThan(expiryDate);
    }
}
