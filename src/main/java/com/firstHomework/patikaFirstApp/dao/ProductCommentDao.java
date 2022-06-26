package com.firstHomework.patikaFirstApp.dao;

import com.firstHomework.patikaFirstApp.entities.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment, Long> {

    //    Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot

    List<ProductComment> findAllByUser_Id(Long userId);

    //    Bir ürüne ait yorumları listeleyen bir metod
    List<ProductComment> findAllByProduct_Id(Long productId);

    //verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot
    List<ProductComment> findAllByProductIdAndCommentDateBetween(Long productId, Date firstDate, Date secondDate);

    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yourmları gösteren bir metot
    List<ProductComment> findAllByUser_IdAndCommentDateBetween(Long userId, Date firstDate, Date secondDate);
}


// Requirements
/*
Bir ürüne ait yorumları listeleyen bir metod//
verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot//
Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot//
Bir kullanıcının belirli tarihler aralığında yapmış olduğu yourmları gösteren bir metot//
son kullanma tarihi geçmiş ürünleri listeleyen bir metot//
son kullanma tarihi geçmemiş ürünleri listeleyen bir metot(son kullanma tarihi boş olanlar da gelmeli)

*/
