package com.example.tddordersystem.payment;

import com.example.tddordersystem.order.Order;
import org.springframework.util.Assert;

class Payment {

    private Long id;
    private final Order order;
    private final String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");

        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
