package com.example.tddordersystem.order;

import com.example.tddordersystem.product.Product;

interface OrderPort {
    Product getProductById(final Long productId);
    void save(final Order order);
}
