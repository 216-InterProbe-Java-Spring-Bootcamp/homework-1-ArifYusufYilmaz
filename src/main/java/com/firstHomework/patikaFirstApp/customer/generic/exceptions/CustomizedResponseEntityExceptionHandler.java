package com.firstHomework.patikaFirstApp.customer.generic.exceptions;

import com.firstHomework.patikaFirstApp.customer.generic.response.RestErrorResponse;
import com.firstHomework.patikaFirstApp.customer.generic.response.RestResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

@RestController
@ControllerAdvice      //tüm restcontrollerlar için controlleradvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler // herhangi bir exception alındığında yakalamak için.
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
        String message = ex.getMessage();
        String detail = webRequest.getDescription(false);
        return getResponseEntity(message, detail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler // business exception alındığında yakalamak için.
    public final ResponseEntity<Object> handleBusinessExceptions(BusinessException ex, WebRequest webRequest){

        String message = ex.getMessage();
        String detail = webRequest.getDescription(false);
        return getResponseEntity(message, detail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler // not found(404) exception alındığında yakalamak için.
    public final ResponseEntity<Object> handleItemNotFoundExceptionExceptions(ItemNotFoundException ex, WebRequest webRequest){

        String message = ex.getMessage();
        String detail = webRequest.getDescription(false);
        return getResponseEntity(message, detail, HttpStatus.NOT_FOUND);
    }
    private ResponseEntity<Object> getResponseEntity(String message, String detail, HttpStatus httpStatus){
        Date errorDate = new Date();
        RestErrorResponse restErrorResponse = new RestErrorResponse(errorDate, message, detail);
        RestResponse<RestErrorResponse> restResponse = RestResponse.error(restErrorResponse);
        //restResponse.setMessage(message);
        ResponseEntity<Object> responseEntity =  new ResponseEntity<>(restResponse, httpStatus);
        return responseEntity;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Validation failed";
        String detail = ex.getBindingResult().toString() ;
        //TODO eksiklik var mı diye kontrol et!
        return getResponseEntity(message, detail,HttpStatus.BAD_REQUEST);
    }
}
// ResponseEntity-> RestResponse -> RestErrorResponse
