package com.firstHomework.patikaFirstApp.dao;

import com.firstHomework.patikaFirstApp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {


    //son kullanma tarihi geçmiş ürünleri listeleyen bir metot
    List<Product> findAllByExpiryDateLessThan(Date expiryDate);
    //son kullanma tarihi geçmemiş ürünleri listeleyen bir metot(son kullanma tarihi boş olanlar da gelmeli)
    List<Product> findAllByExpiryDateGreaterThanOrExpiryDateIsNull(Date expiryDate);

}
