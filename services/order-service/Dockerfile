FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar order-service.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","order-service.jar"]
