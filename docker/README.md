 Docker Configuration

This directory contains Dockerfiles for each microservice.

Each microservice will have its own container image.

Example structure:

docker
├── api-gateway
│   └── Dockerfile
├── user-service
│   └── Dockerfile
├── product-service
│   └── Dockerfile
└── order-service
    └── Dockerfile

These images will be built automatically in the CI pipeline and pushed to Docker Hub.

