package com.nc.product;

import com.nc.brand.Brand;
import com.nc.brand.BrandService;
import com.nc.response.HttpResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        HttpResponse response = new HttpResponse("success", savedProduct, "Product created successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> findAllBrands() {
        return ResponseEntity.ok(brandService.findAllBrands());
    }
}