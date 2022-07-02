package com.firstHomework.patikaFirstApp.customer.service;

import com.firstHomework.patikaFirstApp.customer.converter.CustomerMapper;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerResponseDto;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerSaveRequestDto;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerUpdateRequestDto;
import com.firstHomework.patikaFirstApp.customer.entitiy.Customer;
import com.firstHomework.patikaFirstApp.customer.enums.CustomerErrorMessage;
import com.firstHomework.patikaFirstApp.customer.enums.EnumStatus;
import com.firstHomework.patikaFirstApp.customer.generic.exceptions.BusinessException;
import com.firstHomework.patikaFirstApp.customer.generic.exceptions.ItemNotFoundException;
import com.firstHomework.patikaFirstApp.customer.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerEntityService customerEntityService;

    // diğer işlemler de buraya alındı.derste
    public List<CustomerResponseDto> findAll(){
        List<Customer> customerList = customerEntityService.findAll();
        List<CustomerResponseDto> customerResponseDtoList = CustomerMapper.INSTANCE.mapCustomerListToCustomerResponseDtoList(customerList);
        return customerResponseDtoList;

    }
    public CustomerResponseDto findById(Long id){
        //TODO optional olayı.
        Customer customer = customerEntityService.findById(id).orElse(null);
        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.mapCustomerToCustomerResponseDto(customer);
        return customerResponseDto;
    }
    public CustomerResponseDto save(CustomerSaveRequestDto customerSaveRequestDto){
        Customer customer = CustomerMapper.INSTANCE.mapCustomerSaveRequestDtoToCustomer(customerSaveRequestDto);
        customer.setStatus(EnumStatus.ACTIVE);
        customer = customerEntityService.save(customer);
        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.mapCustomerToCustomerResponseDto(customer);
        return customerResponseDto;
    }
    public void deleteById(Long id){
        customerEntityService.deleteById(id);
    }
    public void delete(Customer customer){
        customerEntityService.delete(customer);
    }

    public CustomerResponseDto cancel(Long id){
        Optional<Customer> customerOp = customerEntityService.findById(id);
        Customer customer = customerOp.get();
        customer.setStatus(EnumStatus.PASSIVE);
        customer.setCancelDate(new Date());

        customer = customerEntityService.save(customer);
        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.mapCustomerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    public CustomerResponseDto update(Long id, CustomerUpdateRequestDto customerUpdateRequestDto) {
        boolean isExist = isExist(customerUpdateRequestDto.getId());
        if(!isExist){
            throw new ItemNotFoundException(CustomerErrorMessage.CUSTOMER_DOES_NOT_EXİST);
        }
        Customer customer = CustomerMapper.INSTANCE.mapCustomerUpdateRequestDtoToCustomer(customerUpdateRequestDto);
        customer = customerEntityService.save(customer);
        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.mapCustomerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    private boolean  isExist(Long id){
        return customerEntityService.isExist(id);
    }
}
