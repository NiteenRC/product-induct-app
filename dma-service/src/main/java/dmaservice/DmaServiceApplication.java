package dmaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DmaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmaServiceApplication.class, args);
    }

}
