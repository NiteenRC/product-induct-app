FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/service-registry.jar

ENTRYPOINT ["java","-jar","service-registry.jar"]