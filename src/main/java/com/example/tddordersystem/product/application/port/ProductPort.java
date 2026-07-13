package com.example.tddordersystem.product.application.port;

import com.example.tddordersystem.product.domain.Product;

public interface ProductPort {
    void save(final Product product);
    Product getProduct(Long productId);
}
