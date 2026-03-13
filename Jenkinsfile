pipeline {

    agent any

    tools {
        jdk 'jdk21'
        maven 'maven3'
    }

    environment {
        SONAR_HOST_URL = "http://13.60.187.173/:9000"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/preethambr30/cloud-native-cicd-kubernetes.git'
            }
        }

        stage('Debug Java') {
    steps {
        sh '''
        java -version
        javac -version
        echo $JAVA_HOME
        which javac
        '''
    }
}

       stage('SonarQube Scan') {
    steps {
        script {

            def services = [
                "api-gateway",
                "order-service",
                "product-service",
                "user-service"
            ]

            for (svc in services) {

                dir("services/${svc}") {

                    withSonarQubeEnv('SonarQube') {

                        sh """
                        mvn clean verify sonar:sonar \
                        -Dsonar.projectKey=${svc} \
                        -Dsonar.host.url=http://13.63.227.226:9000 \
                        -Dsonar.login=\$SONAR_AUTH_TOKEN
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                        """

                    }

                }

            }

        }
    }
}

        stage('Quality Gate') {

            steps {

                timeout(time: 10, unit: 'MINUTES') {

                    script {

                        def gate = waitForQualityGate()

                        if (gate.status != "OK") {
                            error "Pipeline stopped because Quality Gate failed"
                        }

                    }

                }

            }

        }

        stage('Build JAR') {
    steps {
        script {

            dir('services/api-gateway') {
                sh 'mvn clean package'
            }

            dir('services/user-service') {
                sh 'mvn clean package'
            }

            dir('services/order-service') {
                sh 'mvn clean package'
            }

            dir('services/product-service') {
                sh 'mvn clean package'
            }

          }
       }
     }
        stage('Build Docker Images') {
            steps {
                script {

                    sh 'docker build -t preethambr/api-gateway:latest services/api-gateway'
                    sh 'docker build -t preethambr/user-service:latest services/user-service'
                    sh 'docker build -t preethambr/order-service:latest services/order-service'
                    sh 'docker build -t preethambr/product-service:latest services/product-service'

                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script {

                    sh 'docker push preethambr/api-gateway:latest'
                    sh 'docker push preethambr/user-service:latest'
                    sh 'docker push preethambr/order-service:latest'
                    sh 'docker push preethambr/product-service:latest'

                }
            }
        }
       stage('Deploy to Kubernetes') {
           steps {
              sh '''
              kubectl apply -f kubernetes/user-service.yaml
              kubectl apply -f kubernetes/product-service.yaml
              kubectl apply -f kubernetes/order-service.yaml

              kubectl apply -f kubernetes/user-service-deployment.yaml
              kubectl apply -f kubernetes/product-service-deployment.yaml
              kubectl apply -f kubernetes/order-service-deployment.yaml

        kubectl apply -f kubernetes/ingress.yaml
        '''
    }
}
      stage('Update Kubernetes Images') {
    steps {
        sh '''
        kubectl set image deployment/user-service user-service=$DOCKER_USERNAME/user-service:$BUILD_NUMBER
        kubectl set image deployment/product-service product-service=$DOCKER_USERNAME/product-service:$BUILD_NUMBER
        kubectl set image deployment/order-service order-service=$DOCKER_USERNAME/order-service:$BUILD_NUMBER
        '''
    }
}
        
        stage('Verify Kubernetes Deployment') { 
            steps { 
                sh '''
                kubectl get pods
                kubectl get svc
                kubectl get deployments 
                ''' 
            } 
        } 
    }
    
}
