package com.nc.dma;

import com.nc.response.HttpResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@AllArgsConstructor
public class BrandController {
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> createBrand(@RequestBody Brand brand) {
        Brand savedBrand = brandService.saveBrand(brand);
        HttpResponse response = new HttpResponse("success", savedBrand, "Brand created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public Brand updateBrand(@RequestBody Brand brand) {
        return brandService.saveBrand(brand);
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Optional<Brand> getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable Integer id) {
        brandService.deleteBrand(id);
    }
}
