package com.example.tddordersystem.payment.adapter;

interface PaymentGateway {

    void execute(int totalPrice, String cardNumber);
}
