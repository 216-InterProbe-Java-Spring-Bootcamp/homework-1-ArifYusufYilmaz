package com.firstHomework.patikaFirstApp.customer.enums;

import com.firstHomework.patikaFirstApp.customer.generic.exceptions.BaseErrorMessage;

public enum CustomerErrorMessage implements BaseErrorMessage {
    CUSTOMER_DOES_NOT_EXİST("Customer does not exist")
    ;
    private String message;
    CustomerErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return message;
    }
}
