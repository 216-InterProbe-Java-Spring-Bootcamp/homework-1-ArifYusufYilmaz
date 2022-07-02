package com.firstHomework.patikaFirstApp.productcomment;

import java.util.Date;
import java.util.List;

public interface ProductCommentService {
    ProductComment createProductComment(ProductComment productComment);

    List<ProductComment> getAllProductComments();
    List<ProductComment> getAllProductCommentsByUserId(Long userId);
    List<ProductComment> getAllProductCommentsByProductId(Long productId);
    List<ProductComment> getAllProductCommentsByProductIdAndCommentDateBetween(Long productId, Date firstDate, Date secondDate);
    List<ProductComment> getAllProductCommentsByUserIdAndCommentDateBetween(Long userId, Date firstDate, Date secondDate);

}
