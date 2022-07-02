package com.firstHomework.patikaFirstApp.productcomment;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/productcomments")
@RequiredArgsConstructor
public class ProductCommentController {
    private final ProductCommentService productCommentService;
    @PostMapping
    public ProductComment createProductComment(@RequestBody ProductComment productComment)
    {
        return this.productCommentService.createProductComment( productComment);
    }
    @GetMapping("/{userId}")
    public List<ProductComment> getAllProductCommentsByUserId(Long userId){
        return this.productCommentService.getAllProductCommentsByUserId(userId);
    }
    @GetMapping("/{productId}")
    public List<ProductComment> getAllProductCommentsByProductId(Long productId){
        return this.productCommentService.getAllProductCommentsByProductId(productId);
    }
    @GetMapping("/byproduct/{productId}/{firstDate}/{secondDate}")
    public List<ProductComment> getAllProductCommentsByProductIdAndCommentDateBetween(@PathVariable Long productId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date secondDate){
        return this.productCommentService.getAllProductCommentsByProductIdAndCommentDateBetween(productId,firstDate,secondDate);
    }
    @GetMapping("/byuser/{userId}/{firstDate}/{secondDate}")
    public List<ProductComment> getAllProductCommentsByUserIdAndCommentDateBetween(@PathVariable Long userId,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date firstDate,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate){
        return this.productCommentService.getAllProductCommentsByUserIdAndCommentDateBetween(userId,firstDate,secondDate);
    }

}
