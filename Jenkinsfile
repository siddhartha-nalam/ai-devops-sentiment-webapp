pipeline {
    agent any

    environment {
        REGISTRY = "your-docker-registry-url"
        JAVA_IMAGE = "${REGISTRY}/java-app:latest"
        PYTHON_IMAGE = "${REGISTRY}/python-ai-service:latest"
    }

    stages {
        stage('Build Java') {
            steps {
                dir('java-app') {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build Python') {
            steps {
                dir('python-ai-service') {
                    sh 'pip install -r requirements.txt'
                }
            }
        }
        stage('Docker Build & Push') {
            steps {
                sh 'docker build -t $JAVA_IMAGE java-app/'
                sh 'docker build -t $PYTHON_IMAGE python-ai-service/'
                // Login and push steps here
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f kubernetes/'
            }
        }
        stage('Run Selenium Tests') {
            steps {
                dir('selenium-tests') {
                    sh 'pip install -r requirements.txt'
                    sh 'python test_login.py'
                }
            }
        }
    }
}