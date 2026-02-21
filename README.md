# Athletic Sports Microservice Platform

A comprehensive microservices-based platform designed for athletic sports management, built with Spring Boot and Java 21. This platform provides a complete ecosystem for managing athletes, training programs, organizations, memberships, and various sports-related services.

## 🏗️ Architecture Overview

This project follows a microservices architecture pattern with the following core components:

### **Core Services**

| Service | Port | Description |
|---------|------|-------------|
| **API Gateway** | 8080 | Central entry point for all client requests with routing and load balancing |
| **Eureka Server** | 8082 | Service discovery and registration |
| **Auth Service** | 8081 | Authentication, authorization, and user management |
| **Training Service** | 8088 | Training programs, exercises, and athlete progress tracking |
| **Organization Service** | 8086 | Sports organizations and clubs management |
| **Membership Service** | 8085 | Membership subscriptions and requests |
| **Mail Service** | 8084 | Email notifications and communications |
| **Healthy Eating Tip Service** | 8083 | Nutrition and dietary recommendations |
| **Motivation Sentence Service** | 8087 | Motivational content and quotes |

## 🚀 Technology Stack

### **Backend Technologies**
- **Java 21** - Latest Java LTS version with modern features
- **Spring Boot 3.5.9** - Modern Spring framework for microservices
- **Spring Cloud** - Microservices infrastructure components
- **Spring Data JPA** - Database abstraction layer
- **Spring Security** - Authentication and authorization
- **Spring Kafka** - Event-driven communication
- **Spring Cloud Gateway** - API Gateway implementation
- **Eureka Server** - Service discovery

### **Database & Messaging**
- **PostgreSQL** - Primary relational database
- **Apache Kafka** - Event streaming and inter-service communication
- **Hibernate** - ORM framework

### **Development Tools**
- **Maven** - Build and dependency management
- **Lombok** - Reduce boilerplate code
- **MapStruct** - Bean mapping framework
- **OpenAPI/Swagger** - API documentation
- **Spring Boot DevTools** - Development productivity tools

## 📋 Features

### **Authentication & Authorization**
- User registration and login
- Role-based access control (RBAC)
- JWT token management
- User profile management

### **Training Management**
- Training program creation and management
- Exercise library and categorization
- Athlete progress tracking
- Coaching assignments
- Training item and meal item tasks

### **Organization Management**
- Sports clubs and organizations
- Hierarchical organization structure
- Member management within organizations

### **Membership System**
- Subscription management
- Membership requests and approvals
- Different membership tiers

### **Communication Services**
- Email notifications
- Healthy eating tips and recommendations
- Motivational content delivery

## 🛠️ Installation & Setup

### **Prerequisites**
- Java 21 or later
- Maven 3.8+
- PostgreSQL 13+
- Apache Kafka
- Docker (optional, for containerized deployment)

### **Database Setup**
Create the following databases in PostgreSQL:
```sql
CREATE DATABASE as_auth;
CREATE DATABASE as_training;
CREATE DATABASE as_organization;
CREATE DATABASE as_membership;
CREATE DATABASE as_mail;
CREATE DATABASE as_healthy_eating_tip;
CREATE DATABASE as_motivation_sentence;
```

### **Running the Services**

1. **Start Eureka Server** (Service Discovery)
   ```bash
   cd src/eureka-server
   mvn spring-boot:run
   ```

2. **Start API Gateway** (Port 8080)
   ```bash
   cd src/api-gateway
   mvn spring-boot:run
   ```

3. **Start Core Services** (in parallel)
   ```bash
   # Auth Service (Port 8081)
   cd src/auth && mvn spring-boot:run
   
   # Training Service (Port 8088)
   cd src/training && mvn spring-boot:run
   
   # Organization Service (Port 8086)
   cd src/organization && mvn spring-boot:run
   
   # Membership Service (Port 8085)
   cd src/membership && mvn spring-boot:run
   
   # Mail Service (Port 8084)
   cd src/mail && mvn spring-boot:run
   
   # Healthy Eating Tip Service (Port 8083)
   cd src/healthy-eating-tip && mvn spring-boot:run
   
   # Motivation Sentence Service (Port 8087)
   cd src/motivation-sentence && mvn spring-boot:run
   ```

### **Kafka Setup**
Ensure Kafka is running on localhost:9092 for inter-service communication.

### **Running Services in Production Mode**

To run services with production configuration:

1. **Set Environment Variables** (example for Linux/Mac):
   ```bash
   export DB_HOST="jdbc:postgresql://your-prod-db-host:5432/as_auth"
   export DB_USERNAME="your_db_user"
   export DB_PASSWORD="your_secure_password"
   export KAFKA_HOST="your-kafka-cluster:9092"
   export EUREKA_HOST="http://your-eureka-server:8082/eureka"
   export EUREKA_BASE_HOST="your-eureka-server"
   export USER_PROFILE_CLIENT_URL="http://your-auth-service:8081"
   export ORGANIZATION_CLIENT_URL="http://your-organization-service:8086"
   ```

2. **Run Services with Production Profile**:
   ```bash
   # Auth Service (Production)
   cd src/auth
   mvn spring-boot:run -Dspring-boot.run.profiles=prod
   
   # Training Service (Production)
   cd src/training
   mvn spring-boot:run -Dspring-boot.run.profiles=prod
   
   # Other services follow the same pattern
   ```

3. **Using Docker Compose** (recommended for production):
   ```yaml
   # Example docker-compose.yml snippet
   environment:
     - SPRING_PROFILES_ACTIVE=prod
     - DB_HOST=jdbc:postgresql://postgres:5432/as_auth
     - DB_USERNAME=${DB_USERNAME}
     - DB_PASSWORD=${DB_PASSWORD}
     - KAFKA_HOST=kafka:9092
     - EUREKA_HOST=http://eureka-server:8082/eureka
   ```

## 📡 API Documentation

Once all services are running, you can access the API documentation:

- **API Gateway**: `http://localhost:8080`
- **Auth Service Swagger UI**: `http://localhost:8081/swagger-ui.html`
- **Training Service Swagger UI**: `http://localhost:8088/swagger-ui.html`
- **Other Services**: Similar pattern with respective ports

### **API Endpoints Structure**
```
/api/v1/auth/*           - Authentication endpoints
/api/v1/training/*       - Training management
/api/v1/organization/*   - Organization management
/api/v1/membership/*     - Membership operations
/api/v1/mail/*           - Email services
/api/v1/healthyEatingTip/* - Nutrition tips
/api/v1/motivationSentence/* - Motivational content
```

## 🔄 Inter-Service Communication

The platform uses **Apache Kafka** for asynchronous event-driven communication between services:

### **Event Types**
- `UserCreatedEvent` - Triggered when a new user registers
- `OrganizationCreatedEvent` - New organization creation
- `MembershipCreatedEvent` - Membership subscription events
- `MembershipRequestCreatedEvent` - Membership request events
- `TrainingProgramCreatedEvent` - Training program creation

### **Service Communication**
- **Training Service** communicates with **Auth Service** for user validation
- **Training Service** communicates with **Organization Service** for organization data
- All services register with **Eureka** for service discovery
- **API Gateway** routes requests to appropriate services

## 🏛️ Project Structure

```
athletic-sports-microservice/
├── core/                          # Shared core module
│   └── src/main/java/org/ozalp/
│       ├── events/               # Event classes for Kafka
│       ├── models/               # Base entities and models
│       ├── services/             # Base service classes
│       └── utils/                # Constants and utilities
├── src/
│   ├── api-gateway/              # Spring Cloud Gateway
│   ├── eureka-server/            # Service discovery
│   ├── auth/                     # Authentication service
│   ├── training/                 # Training management
│   ├── organization/             # Organization management
│   ├── membership/               # Membership service
│   ├── mail/                     # Email service
│   ├── healthy-eating-tip/       # Nutrition service
│   └── motivation-sentence/      # Motivation service
├── pom.xml                       # Root Maven configuration
└── README.md                     # This file
```

## 🔧 Configuration

### **Environment Profiles**
The project supports multiple environment profiles:

#### **Development Environment**
- Uses `application.yaml` files in each service
- Local database connections (localhost:5432)
- Local Kafka connection (localhost:9092)
- Hardcoded service URLs for inter-service communication

#### **Production Environment**
- Uses `application-prod.yaml` files in each service
- **Environment Variables** for configuration:
  - `DB_HOST` - Database connection URL
  - `DB_USERNAME` - Database username
  - `DB_PASSWORD` - Database password
  - `KAFKA_HOST` - Kafka bootstrap servers
  - `EUREKA_HOST` - Eureka server URL
  - `EUREKA_BASE_HOST` - Eureka server hostname
  - `USER_PROFILE_CLIENT_URL` - Auth service URL for client calls
  - `ORGANIZATION_CLIENT_URL` - Organization service URL for client calls

### **Service Ports**
- API Gateway: 8080
- Auth Service: 8081
- Healthy Eating Tip: 8083
- Mail Service: 8084
- Membership Service: 8085
- Organization Service: 8086
- Motivation Sentence: 8087
- Training Service: 8088
- Eureka Server: 8082

### **Database Configuration**
Each service connects to its own PostgreSQL database:

**Development:**
- URL pattern: `jdbc:postgresql://localhost:5432/as_{service_name}`
- Default credentials: `postgres/123456` (change for production)

**Production:**
- Configured via `DB_HOST`, `DB_USERNAME`, `DB_PASSWORD` environment variables
- Supports any PostgreSQL-compatible database hosting