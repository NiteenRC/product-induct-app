package dmaservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dma")
public class BrandController {

    @GetMapping
    public ResponseEntity<?> findAllBrands() {
        return ResponseEntity.ok("Test Routing..");
    }
}
