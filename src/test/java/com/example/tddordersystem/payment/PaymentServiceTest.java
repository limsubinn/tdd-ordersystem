package com.example.tddordersystem.payment;

import com.example.tddordersystem.order.OrderService;
import com.example.tddordersystem.order.OrderSteps;
import com.example.tddordersystem.product.ProductService;
import com.example.tddordersystem.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());

        final PaymentRequest request = PaymentSteps.상품주문요청_생성();
        paymentService.payment(request);
    }

}
