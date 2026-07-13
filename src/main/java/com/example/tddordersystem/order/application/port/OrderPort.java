package com.example.tddordersystem.order.application.port;

import com.example.tddordersystem.order.domain.Order;
import com.example.tddordersystem.product.domain.Product;

public interface OrderPort {
    Product getProductById(final Long productId);
    void save(final Order order);
}
