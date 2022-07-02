package com.firstHomework.patikaFirstApp.customer.controller;

import com.firstHomework.patikaFirstApp.customer.converter.CustomerMapper;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerResponseDto;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerSaveRequestDto;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerUpdateRequestDto;
import com.firstHomework.patikaFirstApp.customer.entitiy.Customer;
import com.firstHomework.patikaFirstApp.customer.generic.response.RestResponse;
import com.firstHomework.patikaFirstApp.customer.service.CustomerService;
import com.firstHomework.patikaFirstApp.customer.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity findAll(){
        List<CustomerResponseDto> customerResponseDtoList = customerService.findAll();
        return ResponseEntity.ok(RestResponse.of(customerResponseDtoList));
    }
    @PostMapping
    public ResponseEntity save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){
        CustomerResponseDto customerResponseDto= customerService.save(customerSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        CustomerResponseDto customerResponseDto = customerService.findById(id);
        return  ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@Valid @RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
        CustomerResponseDto customerResponseDto =  customerService.update(id, customerUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        customerService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
    @PatchMapping("/cancel/{id}")
    public ResponseEntity cancel(@PathVariable Long id){
        CustomerResponseDto customerResponseDto = customerService.cancel(id);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }

}
