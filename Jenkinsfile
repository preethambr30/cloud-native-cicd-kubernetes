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
                        """

                    }

                }

            }

        }
    }
}

        stage('Quality Gate') {

            steps {

                timeout(time: 2, unit: 'MINUTES') {

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

                sh "mvn clean package"

            }

        }

    }

}
