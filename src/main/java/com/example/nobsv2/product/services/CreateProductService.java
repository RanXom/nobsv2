package com.example.nobsv2.product.services;

import com.example.nobsv2.Command;
import com.example.nobsv2.exceptions.ErrorMessages;
import com.example.nobsv2.exceptions.ProductNotValidException;
import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

        // Validate data before saving
        validateProduct(product);

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }

    private static void validateProduct(Product product) {
        if (StringUtils.isEmpty(product.getName())) {
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if (product.getDescription().length() < 20) {
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if (product.getPrice() == null || product.getPrice() < 0.00) {
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }
    }

}
