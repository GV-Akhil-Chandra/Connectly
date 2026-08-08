This project is a functional replica of LinkedIn’s core features, focusing on decoupled services, efficient data management, and real-time interactions. The system is designed to handle post management, social networking (connections), and notifications.\

<b>🛠 Tech Stack</b>\
Framework: Spring Boot (Java)\
Architecture: Microservices\
Database: PostgreSQL and Neo4j\
Communication: Kafka, REST / gRPC\
Service Discovery: Netflix Eureka / Spring Cloud Gateway\
Containerization: Docker & Docker Compose\

<b>🏗 System Architecture</b>\
<b>Post Service:</b> Handles creation, retrieval, and deletion of user posts. Manages likes and comments on posts.\
<b>User Service:</b> Manages login and signup flows.\
<b>Connection Service:</b> Manages user networking (sending/accepting requests).\
<b>Uploader service:</b> Used to upload images as part of posts (Cloudinary).\
<b>Notification Service:</b> Asynchronous notifications powered by Kafka.\
<b>API-Gateway:</b> Unified entry for all the api's.\
<b>Discovery service:</b> For registering and providing route for the member services.\

<b>✨ Key Features</b>\
User Posts: CRUD operations for posts.\
Social Interactions: Like and comment functionality.\
Networking: Send and manage connection requests.\
Notifications: Real-time updates for interactions, post update, connection requests.\
Microservices: Decoupled design for scalability.\

<b>⚙️ Getting Started (Prerequisites)</b>\
Java 25\
Docker\
Kafka\
Redis\
Gradle\
Zipkin\
ELK stack\
