package com.firstHomework.patikaFirstApp.customer.dto;

import com.firstHomework.patikaFirstApp.customer.enums.EnumStatus;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerUpdateRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private Date birthDate;
    private EnumStatus status;
    private Date cancelDate;
}
