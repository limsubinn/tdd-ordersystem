package com.example.tddordersystem.payment;

import com.example.tddordersystem.order.Order;

interface PaymentPort {

    Order getOrder(Long orderId);
    void pay(int totalPrice, String cardNumber);
    void save(Payment payment);
}
