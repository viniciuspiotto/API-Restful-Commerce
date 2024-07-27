package com.piotto.apiproduct.domain;

import com.piotto.apiproduct.domain.enums.PaymentState;
import jakarta.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment {
    private Integer numberOfInstallments;

    public CreditCardPayment() {}

    public CreditCardPayment(Integer id, PaymentState state, Order order, Integer numberOfInstallments) {
        super(id, state, order);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}
