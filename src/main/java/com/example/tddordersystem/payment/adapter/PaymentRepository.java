package com.example.tddordersystem.payment.adapter;

import com.example.tddordersystem.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PaymentRepository extends JpaRepository<Payment, Long> {
}
