# AI DevOps Sentiment WebApp

A complete end-to-end project for DevOps and AI learning, integrating:
- Java (Spring Boot) web application (with login)
- Python microservice for sentiment analysis (AI)
- Containerized with Docker and orchestrated with Kubernetes
- CI/CD using Jenkins and GitLab
- Infrastructure as Code (Terraform) on AWS
- Automated UI testing with Selenium
- Deployed using Tomcat and Maven

## Architecture

```
[User]
   |
   v
[Java Web App (Spring Boot, Tomcat, Maven)]
   |
   v
[Python AI Microservice (Flask)]
   |
   v
[MySQL/PostgreSQL DB]
   |
   v
[Docker Containers]
   |
   v
[Kubernetes on AWS EKS]
   |
   v
[CI/CD: Jenkins & GitLab]
   |
   v
[Provisioned via Terraform]
```

---

## Project Structure

```
ai-devops-sentiment-webapp/
│
├── java-app/                  # Java Spring Boot Web App (Tomcat)
├── python-ai-service/         # Python Flask/FastAPI Sentiment Service
├── selenium-tests/            # Selenium UI tests
├── terraform/                 # Terraform IaC for AWS setup
├── kubernetes/                # Kubernetes YAML manifests
├── .gitlab-ci.yml             # GitLab CI/CD pipeline
├── Jenkinsfile                # Jenkins pipeline
├── .gitignore
└── README.md
```

---

## Getting Started

### 1. Prerequisites

- Linux (Ubuntu recommended)
- Docker & Docker Compose
- AWS account (with CLI configured)
- Terraform
- Java 17+, Maven
- Python 3.8+
- Node.js (optional, for frontend tweaks)
- Jenkins (local or EC2)
- GitLab account
- kubectl & eksctl

### 2. Clone the Repository

```bash
git clone https://github.com/siddhartha-nalam/ai-devops-sentiment-webapp.git
cd ai-devops-sentiment-webapp
```

---

## Modules & Setup

### Java Web App

- Located in `java-app/`
- Spring Boot + Thymeleaf + Maven
- Handles login, user registration, and submits text to Python service

#### Run Locally

```bash
cd java-app
mvn clean package
java -jar target/java-app-0.0.1-SNAPSHOT.jar
```

---

### Python AI Microservice

- Located in `python-ai-service/`
- Flask API for sentiment analysis

#### Run Locally

```bash
cd python-ai-service
pip install -r requirements.txt
python app.py
```

---

### Docker Compose (Local Dev)

- One command to run both services + DB

```bash
docker-compose up --build
```

---

### Terraform (AWS Infrastructure)

- Located in `terraform/`
- Provisions:
  - AWS EKS (Kubernetes)
  - RDS (DB)
  - IAM, VPC, Security Groups

```bash
cd terraform
terraform init
terraform apply
```

---

### Kubernetes

- Located in `kubernetes/`
- Deploys apps to EKS

```bash
kubectl apply -f kubernetes/
```

---

### CI/CD

#### GitLab

- `.gitlab-ci.yml` for GitLab pipeline
- Automates: test, build Docker images, push, deploy, trigger Selenium tests

#### Jenkins

- `Jenkinsfile` for Jenkins pipeline

---

### Selenium Tests

- Located in `selenium-tests/`
- Python scripts to automate login and sentiment analysis UI tests

```bash
cd selenium-tests
pip install -r requirements.txt
python test_login.py
```

---

## Technologies Used

- Java, Spring Boot, Maven, Tomcat
- Python, Flask, TextBlob/NLTK
- Docker, Docker Compose
- Kubernetes, Helm
- AWS EKS, RDS
- Terraform
- Jenkins, GitLab CI
- Selenium
- Linux, Bash

---

## Contribution

1. Fork and clone the repo
2. Create your feature branch
3. Commit your changes
4. Push to your branch
5. Open a pull request

---

## License

MIT

---

## Author

[Siddhartha Nalam](https://github.com/siddhartha-nalam)
