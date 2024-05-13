FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/dma-service.jar

ENTRYPOINT ["java","-jar","dma-service.jar"]