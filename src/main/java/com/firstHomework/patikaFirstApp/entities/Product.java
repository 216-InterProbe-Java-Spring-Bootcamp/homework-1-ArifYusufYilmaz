package com.firstHomework.patikaFirstApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="products")
@Data
public class Product {
    @Id
    @SequenceGenerator( name="ProductController", sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductController")
    private Long id;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name = "PRICE")
    private double price;
    @Column(name="EXPIRY_DATE", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductComment> productComments;
}
