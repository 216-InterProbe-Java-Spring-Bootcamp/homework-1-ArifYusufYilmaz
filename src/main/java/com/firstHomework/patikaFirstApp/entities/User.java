package com.firstHomework.patikaFirstApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @SequenceGenerator( name="UserDao", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserDao")
    private Long id;
    @Column(name="FIRST_NAME", length=50)
    private String firstName;       //char50
    @Column(name="LAST_NAME", length=50)
    private String lastName;        //char50
    @Email
    @Column(name="EMAIL", length=50)
    private String email;           //char50
    @Column(name="PHONE_NUMBER", length=15)     //Long?
    private String phoneNumber;       //char15

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ProductComment> productComments;
}
