package com.firstHomework.patikaFirstApp.customer.generic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {
    @Column(name = "create_date", updatable= false)
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date" )
    @LastModifiedDate
    private Date updateDate;
    @Column(name="crated_by", updatable = false)
    @CreatedBy
    private Long createdBy;
    @Column(name="updated_by")
    @LastModifiedBy
    private Long updatedBy;
}
