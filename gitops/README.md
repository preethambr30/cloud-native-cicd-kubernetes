  GitOps Configuration

This directory contains configuration files for GitOps deployment using ArgoCD.

ArgoCD continuously monitors the Git repository and synchronizes the Kubernetes cluster state with the desired state defined in Git.

Workflow:

 GitHub → ArgoCD → Kubernetes

 Benefits of GitOps:

 Automated deployments
 Version-controlled infrastructure
 Easy rollback
 Improved security

