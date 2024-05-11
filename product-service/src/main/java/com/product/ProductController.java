package com.product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/product")
@Log4j2
public class ProductController {
    @Autowired
    private final RestTemplate restTemplate;

    @GetMapping
    @CircuitBreaker(name = "findAllBrands", fallbackMethod = "fallbackDmaService")
    public ResponseEntity<String> findAllBrands() {
        log.info("Test Instances..1");
        String url = "http://DMA-SERVICE/api/dma";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<String> fallbackDmaService(Throwable ex) {
        String message = "DMA service is under maintenance";
        log.error(message, ex);
        return ResponseEntity.ok(message);
    }
}