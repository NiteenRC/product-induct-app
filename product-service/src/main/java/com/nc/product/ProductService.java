package com.nc.product;

import com.nc.exception.ConflictException;
import com.nc.exception.CreationException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        try {
            String productName = product.getProductName().trim();
            if (productRepository.existsByProductName(productName)) {
                throw new ConflictException("Product already exists");
            } else {
                product.setProductName(productName);
                return productRepository.save(product);
            }
        } catch (CreationException e) {
            log.error("Failed to create product: " + e.getMessage());
            throw new CreationException("Failed to create new product");
        }
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
