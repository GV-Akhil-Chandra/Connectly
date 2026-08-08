This project is a functional replica of LinkedIn’s core features, focusing on decoupled services, efficient data management, and real-time interactions. The system is designed to handle post management, social networking (connections), and notifications.

🛠 Tech Stack
Framework: Spring Boot (Java)
Architecture: Microservices
Database: PostgreSQL and Neo4j
Communication: Kafka, REST / gRPC
Service Discovery: Netflix Eureka / Spring Cloud Gateway
Containerization: Docker & Docker Compose

🏗 System Architecture
Post Service: Handles creation, retrieval, and deletion of user posts. Manages likes and comments on posts
User Service: Manages login and signup flows.
Connection Service: Manages user networking (sending/accepting requests).
Uploader service: Used to upload images as part of posts (Cloudinary).
Notification Service: Asynchronous notifications powered by Kafka.
API-Gateway: Unified entry for all the api's.
Discovery service: For registering and providing route for the member services.


✨ Key Features
User Posts: CRUD operations for posts.
Social Interactions: Like and comment functionality.
Networking: Send and manage connection requests.
Notifications: Real-time updates for interactions, post update, connection requests.
Microservices: Decoupled design for scalability.

⚙️ Getting Started
Prerequisites
Java 25
Docker
Kafka
Redis
Gradle
Zipkin
ELK stack
