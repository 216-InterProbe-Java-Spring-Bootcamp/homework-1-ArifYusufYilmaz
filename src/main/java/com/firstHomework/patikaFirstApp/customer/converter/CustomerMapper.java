package com.firstHomework.patikaFirstApp.customer.converter;

import com.firstHomework.patikaFirstApp.customer.dto.CustomerResponseDto;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerSaveRequestDto;
import com.firstHomework.patikaFirstApp.customer.dto.CustomerUpdateRequestDto;
import com.firstHomework.patikaFirstApp.customer.entitiy.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerResponseDto mapCustomerToCustomerResponseDto(Customer customer);
    List<CustomerResponseDto> mapCustomerListToCustomerResponseDtoList(List<Customer> customerList);
    Customer mapCustomerSaveRequestDtoToCustomer(CustomerSaveRequestDto customerRequestDto);
    Customer mapCustomerUpdateRequestDtoToCustomer(CustomerUpdateRequestDto customerUpdateDto);
}
