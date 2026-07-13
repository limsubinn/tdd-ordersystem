package com.example.tddordersystem.payment.application.port;

import com.example.tddordersystem.order.domain.Order;
import com.example.tddordersystem.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(Long orderId);
    void pay(int totalPrice, String cardNumber);
    void save(Payment payment);
}
