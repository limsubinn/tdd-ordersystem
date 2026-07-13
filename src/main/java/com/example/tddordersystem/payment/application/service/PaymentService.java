package com.example.tddordersystem.payment.application.service;

import com.example.tddordersystem.order.domain.Order;
import com.example.tddordersystem.payment.domain.Payment;
import com.example.tddordersystem.payment.application.port.PaymentPort;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentService {

    private final PaymentPort paymentPort;

    PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> payment(@RequestBody final PaymentRequest request) {
        final Order order = paymentPort.getOrder(request.orderId());
        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);

        return ResponseEntity.ok().build();
    }
}
