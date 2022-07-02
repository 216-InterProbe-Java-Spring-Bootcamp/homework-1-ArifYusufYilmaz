package com.firstHomework.patikaFirstApp.customer.service.entityservice;

import com.firstHomework.patikaFirstApp.customer.dao.CustomerDao;
import com.firstHomework.patikaFirstApp.customer.entitiy.Customer;
import com.firstHomework.patikaFirstApp.customer.generic.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerEntityService extends BaseEntityService<Customer,CustomerDao> {

    public CustomerEntityService(CustomerDao dao){
        super(dao);
    }

}
