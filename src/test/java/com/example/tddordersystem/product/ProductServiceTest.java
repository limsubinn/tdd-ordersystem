package com.example.tddordersystem.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        // 상품 수정
        final long productId = 1L;
        final UpdateProductRequest request = ProductSteps.상품수정요청_생성();
        productService.updateProduct(productId, request);

        // 상품의 응답을 검증
        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();
        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);
    }
}
