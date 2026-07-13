package com.example.tddordersystem.payment.adapter;

import com.example.tddordersystem.order.domain.Order;
import com.example.tddordersystem.order.adapter.OrderRepository;
import com.example.tddordersystem.payment.domain.Payment;
import com.example.tddordersystem.payment.application.port.PaymentPort;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
