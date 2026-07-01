package com.example.tddordersystem.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private ProductPort productPort;
    private ProductService productService;

    @BeforeEach
    void setup() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품수정() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        final long productId = 1L;
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        // 상품 수정
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        productService.updateProduct(productId, request);

        // 상품의 응답을 검증
        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }
}
