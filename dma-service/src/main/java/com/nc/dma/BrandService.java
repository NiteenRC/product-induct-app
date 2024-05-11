package com.nc.dma;

import com.nc.exception.ConflictException;
import com.nc.exception.CreationException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class BrandService {
    private BrandRepository brandRepository;

    public Brand saveBrand(Brand brand) {
        try {
            String brandName = brand.getBrandName().trim();
            if (brandRepository.existsByBrandName(brandName)) {
                throw new ConflictException("Brand already exists");
            } else {
                brand.setBrandName(brandName);
                return brandRepository.save(brand);
            }
        } catch (CreationException e) {
            log.error("Failed to create brand: " + e.getMessage());
            throw new CreationException("Failed to create new brand");
        }
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Integer id) {
        return brandRepository.findById(id);
    }

    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }
}
