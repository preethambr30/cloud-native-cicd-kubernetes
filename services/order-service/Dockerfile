FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/*.jar order-service.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","order-service.jar"]
