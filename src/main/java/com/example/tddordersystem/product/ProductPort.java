package com.example.tddordersystem.product;

interface ProductPort {
    void save(final Product request);
    Product getProduct(Long productId);
}
