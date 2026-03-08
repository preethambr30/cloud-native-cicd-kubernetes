 Microservices Source Code

This directory contains the Java Spring Boot microservices used in the project.

 Services

 Api-gateway → Entry point for client requests
 User-service → Handles user management
 Product-service → Manages product information
 Order-service → Handles order processing

Each service will be containerized using Docker and deployed into Kubernetes.

These services communicate through REST APIs and are exposed through the API Gateway.

