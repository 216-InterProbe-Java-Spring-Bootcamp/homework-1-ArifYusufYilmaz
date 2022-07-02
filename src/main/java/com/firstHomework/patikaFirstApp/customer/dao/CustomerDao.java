package com.firstHomework.patikaFirstApp.customer.dao;

import com.firstHomework.patikaFirstApp.customer.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
