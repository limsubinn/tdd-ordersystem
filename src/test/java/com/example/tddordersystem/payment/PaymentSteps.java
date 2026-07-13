package com.example.tddordersystem.payment;

public class PaymentSteps {

    public static PaymentRequest 상품주문요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }
}
