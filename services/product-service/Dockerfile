FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/*.jar product-service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","product-service.jar"]
