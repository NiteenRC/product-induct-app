package dmaservice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dma")
@Log4j2
public class BrandController {

    @GetMapping
    public ResponseEntity<?> findAllBrands() {
        log.info("Test Instances..");
        return ResponseEntity.ok("Test Routing..");
    }
}
