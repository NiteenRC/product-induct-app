# Product Induct App

### Steps to Follow for Running Microservices:

1. Service Registry
2. Config Server
3. API Gateway
4. DMA Service
5. Product Service

### API Documentation

- DMA
  Service: [http://localhost:8080/api/dma/swagger-ui/index.html](http://localhost:8080/api/dma/swagger-ui/index.html)
- Product
  Service: [http://localhost:8080/api/product/swagger-ui/index.html](http://localhost:8080/api/product/swagger-ui/index.html)

### Circuit Breaker

- Verify Closed, Open, and Half-Open
  States: [http://localhost:8080/api/product/actuator/health](http://localhost:8080/api/product/actuator/health)

### Config Server

- Verify Profiles:
    - Default: [http://localhost:8080/api/config/actuator/default](http://localhost:8080/api/config/actuator/default)
    - Dev: [http://localhost:8080/api/config/actuator/dev](http://localhost:8080/api/config/actuator/dev)