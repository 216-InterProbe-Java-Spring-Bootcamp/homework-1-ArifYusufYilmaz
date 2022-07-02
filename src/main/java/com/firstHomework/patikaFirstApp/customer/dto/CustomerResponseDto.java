package com.firstHomework.patikaFirstApp.customer.dto;

import com.firstHomework.patikaFirstApp.customer.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
public class CustomerResponseDto {
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
