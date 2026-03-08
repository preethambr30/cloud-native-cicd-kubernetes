  Docker Configuration

This directory contains the Dockerfiles used to build container images for each microservice in this project.

Each microservice is packaged as a separate Docker image.

 Folder Structure

```
docker
├── api-gateway
│   └── Dockerfile
├── user-service
│   └── Dockerfile
├── product-service
│   └── Dockerfile
└── order-service
    └── Dockerfile
```

 Purpose

These Dockerfiles are used in the CI/CD pipeline to:

1. Build container images for each microservice
2. Push the images to Docker Hub
3. Deploy the images to the Kubernetes cluster

 Workflow


Developer → GitHub → GitHub Actions → Docker Build → Docker Hub → Kubernetes


Kubernetes then pulls the images and runs them using **containerd** as the container runtime.


