package com.example.tddordersystem.order;

import com.example.tddordersystem.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
class OrderService {

    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());
        orderPort.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
