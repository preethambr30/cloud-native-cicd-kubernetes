# Setup Guide

This guide explains how to set up and run the **Cloud Native CI/CD Microservices Project** locally or on a cloud server.

The project demonstrates a complete DevOps workflow using **Jenkins, Docker, Kubernetes, and SonarQube**.

---

# Prerequisites

Before running the project, install the following tools:

* Java JDK 21
* Maven
* Docker
* Kubernetes (kubectl)
* Jenkins
* SonarQube
* Git

Verify installations:

```
java -version
mvn -version
docker --version
kubectl version
git --version
```

---

# Clone the Repository

Clone the project repository from GitHub.

```
git clone https://github.com/preethambr30/cloud-native-cicd-kubernetes.git
cd cloud-native-cicd-kubernetes
```

---

# Project Structure

The repository contains the following main directories:

```
cloud-native-cicd-kubernetes
│
├── services
│   ├── api-gateway
│   ├── user-service
│   ├── product-service
│   └── order-service
│
├── kubernetes
│   ├── api-gateway-deployment.yaml
│   ├── user-service-deployment.yaml
│   ├── product-service-deployment.yaml
│   ├── order-service-deployment.yaml
│   └── ingress.yaml
│
├── docs
│   ├── architecture.md
│   ├── pipeline.md
│   └── setup-guide.md
```

Each service is a **Spring Boot microservice** with its own Dockerfile and Maven build configuration.

---

# Build Microservices

Build each service using Maven:

```
cd services/api-gateway
mvn clean package

cd ../user-service
mvn clean package

cd ../product-service
mvn clean package

cd ../order-service
mvn clean package
```

---

# Build Docker Images

Create Docker images for each microservice.

```
docker build -t preethambr/api-gateway:latest services/api-gateway
docker build -t preethambr/user-service:latest services/user-service
docker build -t preethambr/product-service:latest services/product-service
docker build -t preethambr/order-service:latest services/order-service
```

---

# Push Images to Docker Hub

Login to Docker Hub and push the images.

```
docker login

docker push preethambr/api-gateway:latest
docker push preethambr/user-service:latest
docker push preethambr/product-service:latest
docker push preethambr/order-service:latest
```

---

# Deploy to Kubernetes

Apply Kubernetes configuration files.

```
kubectl apply -f kubernetes/user-service.yaml
kubectl apply -f kubernetes/product-service.yaml
kubectl apply -f kubernetes/order-service.yaml
kubectl apply -f kubernetes/api-gateway.yaml
kubectl apply -f kubernetes/ingress.yaml
```

Verify deployment:

```
kubectl get pods
kubectl get services
kubectl get ingress
```

---

# Access the Application

Open the API Gateway endpoint in your browser:

```
http://<EC2-PUBLIC-IP>:30007/users
http://<EC2-PUBLIC-IP>:30007/products
http://<EC2-PUBLIC-IP>:30007/orders
```

These endpoints confirm that the microservices are running correctly.

---

# CI/CD Pipeline Execution

The Jenkins pipeline automates the following steps:

1. Checkout source code
2. Run SonarQube analysis
3. Build microservices
4. Build Docker images
5. Push images to Docker Hub
6. Deploy to Kubernetes

The pipeline is defined in the **Jenkinsfile** in the repository.

---

# Verify Deployment

Run the following commands to confirm the cluster status:

```
kubectl get pods
kubectl get services
kubectl get deployments
```

All microservices should be in **Running** state.

---

# Conclusion

This setup demonstrates a complete **cloud-native DevOps pipeline**, including:

* Microservices architecture
* Docker containerization
* Kubernetes orchestration
* Jenkins CI/CD automation
* SonarQube code quality analysis

The project reflects a real-world DevOps deployment workflow used in modern cloud environments.
