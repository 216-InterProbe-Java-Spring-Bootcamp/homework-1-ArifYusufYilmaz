package com.firstHomework.patikaFirstApp.business.concretes;

import com.firstHomework.patikaFirstApp.business.abstracts.ProductCommentService;
import com.firstHomework.patikaFirstApp.dao.ProductCommentDao;
import com.firstHomework.patikaFirstApp.entities.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentManager implements ProductCommentService {
    private final ProductCommentDao productCommentDao;

    @Override
    public ProductComment createProductComment(ProductComment productComment) {
        return this.productCommentDao.save(productComment);
    }

    @Override
    public List<ProductComment> getAllProductComments() {
        return this.productCommentDao.findAll();
    }
    @Override
    public List<ProductComment> getAllProductCommentsByUserId(Long userId) {
        return this.productCommentDao.findAllByUser_Id(userId);
    }
    @Override
    public List<ProductComment> getAllProductCommentsByProductId(Long productId) {
        return this.productCommentDao.findAllByProduct_Id(productId);
    }
    @Override
    public List<ProductComment> getAllProductCommentsByProductIdAndCommentDateBetween(Long productId, Date firstDate, Date secondDate) {
        return this.productCommentDao.findAllByProductIdAndCommentDateBetween(productId,firstDate,secondDate);
    }
    @Override
    public List<ProductComment> getAllProductCommentsByUserIdAndCommentDateBetween(Long userId, Date firstDate, Date secondDate) {
        return this.productCommentDao.findAllByUser_IdAndCommentDateBetween(userId,firstDate,secondDate);
    }
}
