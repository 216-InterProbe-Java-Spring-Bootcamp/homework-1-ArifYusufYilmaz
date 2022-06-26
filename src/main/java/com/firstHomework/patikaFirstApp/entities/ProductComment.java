package com.firstHomework.patikaFirstApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_comments")
@Data
public class ProductComment {
    @Id
    @SequenceGenerator(name ="ProductComment", sequenceName = "PRODUCT_COMMENT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "ProductComment")
    private Long id;
    @Column(name ="COMMENT", length = 500)
    private String comment;     // char500
    @Column(name="COMMENT_DATE")
    @Temporal(TemporalType.DATE)

    private Date commentDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT", foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_PRODUCT"))
    @JsonBackReference
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_USER", foreignKey=@ForeignKey(name="FK_PRODUCT_COMMENT_USER"))
    @JsonBackReference
    private User user;
}
