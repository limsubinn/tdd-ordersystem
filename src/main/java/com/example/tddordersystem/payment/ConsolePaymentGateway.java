package com.example.tddordersystem.payment;

import org.springframework.stereotype.Component;

@Component
class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void execute(int totalPrice, String cardNumber) {
        System.out.println("결제 완료");
    }
}
