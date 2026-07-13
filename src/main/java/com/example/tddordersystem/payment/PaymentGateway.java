package com.example.tddordersystem.payment;

interface PaymentGateway {

    void execute(int totalPrice, String cardNumber);
}
