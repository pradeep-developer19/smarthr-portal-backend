# SmartHR Portal Backend

SmartHR Portal Backend is a **Spring Boot based REST API application** designed to manage employee data, authentication, and HR operations securely using **JWT authentication and role-based access control**.

This project demonstrates modern backend development practices including **Spring Security, DTO mapping, exception handling, and layered architecture**.

---

## 🚀 Features

* JWT Authentication & Authorization
* Role-Based Access Control (Admin / HR)
* Secure REST APIs
* Employee Management (CRUD)
* Department Management
* Leave Management
* Attendance Tracking
* Global Exception Handling
* DTO & Mapper Pattern
* Password Encryption using Spring Security
* Audit Logging

---

## 🛠 Tech Stack

| Technology      | Description                    |
| --------------- | ------------------------------ |
| Java            | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| JWT             | Token Based Authentication     |
| Maven           | Dependency Management          |
| MySQL           | Database                       |
| JPA / Hibernate | ORM Framework                  |
| Postman         | API Testing                    |

---

## 📂 Project Structure

```
smarthr-portal-backend
│
├── controller
│   ├── AuthController
│   ├── EmployeeController
│   ├── AdminController
│   └── HrController
│
├── service
│   ├── AuthService
│   └── EmployeeService
│
├── service/impl
│   ├── AuthServiceImpl
│   └── EmployeeServiceImpl
│
├── repository
│   ├── EmployeeRepository
│   ├── UserRepository
│   ├── AttendanceRepository
│   └── DepartmentRepository
│
├── entity
│   ├── Employee
│   ├── User
│   ├── Role
│   ├── Department
│   ├── Attendance
│   └── LeaveManagement
│
├── security
│   ├── SecurityConfig
│   ├── JwtAuthenticationFilter
│   └── JwtService
│
├── dto
├── mapper
├── exception
└── util
```

---

## 🔐 Authentication Flow

1. User sends **login request**
2. System verifies credentials
3. **JWT Token is generated**
4. Client uses token in headers:

```
Authorization: Bearer <token>
```

5. Secure APIs validate the token before processing requests

---

## 📡 API Endpoints

### Authentication

| Method | Endpoint        | Description            |
| ------ | --------------- | ---------------------- |
| POST   | /api/auth/login | Login and generate JWT |

---

### Employee APIs

| Method | Endpoint            | Description        |
| ------ | ------------------- | ------------------ |
| GET    | /api/employees      | Get all employees  |
| GET    | /api/employees/{id} | Get employee by ID |
| POST   | /api/employees      | Create employee    |
| PUT    | /api/employees/{id} | Update employee    |
| DELETE | /api/employees/{id} | Delete employee    |

---

## 🧪 API Testing

The APIs are tested using **Postman**.

Steps:

1. Login using `/api/auth/login`
2. Copy the generated **JWT Token**
3. Add token in request header:

```
Authorization: Bearer <token>
```

4. Access secured endpoints like `/api/employees`

---

## ⚙️ Running the Project

### 1️⃣ Clone the Repository

```
git clone https://github.com/pradeep-developer19/smarthr-portal-backend.git
```

---

### 2️⃣ Navigate to Project

```
cd smarthr-portal-backend
```

---

### 3️⃣ Configure Database

Update **application.properties**

```
spring.datasource.url=jdbc:mysql://localhost:3306/smarthr
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

### 4️⃣ Run the Application

```
mvn spring-boot:run
```

---

## 📸 Postman Screenshots

Add screenshots here:

* Login API
* JWT Token generation
* Get Employees API
* Create Employee API

---

## 📈 Future Improvements

* Swagger API Documentation
* Docker Containerization
* Refresh Token Authentication
* Pagination & Filtering
* Unit Testing with JUnit
* CI/CD Pipeline

---

## 👨‍💻 Author

**Pradeep**

Backend Developer (Java / Spring Boot)

GitHub:
https://github.com/pradeep-developer19

---

## ⭐ If you like this project

Give it a **star ⭐ on GitHub**
