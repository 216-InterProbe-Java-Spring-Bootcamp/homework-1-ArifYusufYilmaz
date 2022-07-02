package com.firstHomework.patikaFirstApp.customer.dto;

import com.firstHomework.patikaFirstApp.customer.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class CustomerSaveRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    @Size(min=3, max=10)
    private String username;
    @Size(min=8)
    private String password;
    private String phoneNumber;
    private String email;
    private Date birthDate;
}
