package com.firstHomework.patikaFirstApp.customer.generic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel,Serializable,Cloneable{

    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseAdditionalFields additionalFields;
}
