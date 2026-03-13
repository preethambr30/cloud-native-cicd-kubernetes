# System Architecture

This project demonstrates a **cloud-native microservices architecture** deployed on a Kubernetes cluster.

Each microservice is built using **Spring Boot**, containerized using **Docker**, and deployed on **Kubernetes**.

The system is automated using a **CI/CD pipeline with Jenkins**, and code quality is analyzed using **SonarQube**.

---

## Application Components

The application consists of the following components:

- API Gateway  
- User Service  
- Product Service  
- Order Service  
- Kubernetes Cluster  
- NGINX Ingress Controller  

---

## Kubernetes Pod Deployment

The following screenshot shows all running microservice pods inside the Kubernetes cluster.

Pods are responsible for running containerized microservices. Each service runs multiple pods to provide **high availability** and **scalability**.

![Kubernetes Pods](images/pods.png)

From the screenshot we can see:

- API Gateway pods running  
- User Service pods running  
- Product Service pods running  
- Order Service pods running  

This confirms that all services are successfully deployed in the cluster.

---

## Kubernetes Services

Kubernetes Services allow communication between different microservices inside the cluster.

![Kubernetes Services](images/services.png)

In this project:

- **api-gateway-service** is exposed using **NodePort**
- **user-service**, **product-service**, and **order-service** use **ClusterIP** for internal communication.

---

## Kubernetes Ingress

NGINX Ingress is used to route external traffic to the API Gateway.

![Kubernetes Ingress](images/ingress.png)

Ingress acts as the entry point for external traffic and forwards requests to the appropriate microservice.

---

## User Service API

The following screenshot shows the **User Service endpoint** accessed through the API Gateway.

![User API](images/users.png)

---

## Order Service API

The following screenshot shows the **Order Service endpoint** accessed through the API Gateway.

![Order API](images/orders.png)

---

## Product Service API

The following screenshot shows the **Product Service endpoint** accessed through the API Gateway.

![Product API](images/products.png)

---

## Architecture Summary

This project demonstrates a complete **DevOps workflow** including:

- Microservices architecture using Spring Boot  
- Docker containerization  
- Kubernetes deployment and orchestration  
- NGINX Ingress for routing external traffic  
- Jenkins CI/CD pipeline  
- SonarQube for code quality analysis  

This architecture represents a **real-world cloud-native deployment pipeline**.

