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
- URL pattern: `jdbc:postgresql://localhost:5432/as_{service_name}`
- Default credentials: `postgres/123456` (change for production)