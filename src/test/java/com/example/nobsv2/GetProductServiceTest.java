package com.example.nobsv2;

import com.example.nobsv2.exceptions.ProductNotFoundException;
import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {

    @Mock   // What to mock the response of, this is needed to perform the tests
    private ProductRepository productRepository;

    @InjectMocks    // What we are testing
    private GetProductService getProductService;

    @BeforeEach     // Initializes the things we need before starting the tests
    public void setUp() {
        // Initializes the repository and the service
        MockitoAnnotations.openMocks(this);
    }

    @Test   // Define the tests
    public void given_product_exists_when_get_product_service_returns_product_dto() {

        // Given
        Product product = new Product();
        product.setId(1);
        product.setName("Test");
        product.setDescription("This is a test product description with atleast 20 characters");
        product.setPrice(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // When
        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        // Then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);

        // Assert the product repository was only called once
        verify(productRepository, times(1)).findById(1);

    }

    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception() {

        // Given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);
    }
}
