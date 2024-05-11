package com.nc.brand;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class BrandService {
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "dmaServiceFetchAllBrands", fallbackMethod = "fallbackDmaService")
    public List<Brand> findAllBrands() {
        ResponseEntity<List<Brand>> responseEntity = restTemplate.exchange(
                "http://DMA-SERVICE/api/dma",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }

    public List<Brand> fallbackDmaService(Throwable ex) {
        String message = "DMA service is DOWN!!";
        log.error(message, ex);

        Brand brand1 = new Brand(1, "Brand A", "Description A", "Country A", "Active");
        Brand brand2 = new Brand(2, "Brand B", "Description B", "Country B", "Inactive");
        return Arrays.asList(brand1, brand2);
    }
}