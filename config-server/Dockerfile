FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/config-server.jar

ENTRYPOINT ["java","-jar","config-server.jar"]