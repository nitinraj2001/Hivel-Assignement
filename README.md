## 2. High Level Design

This service is designed as a REST-based backend using Spring Boot. The system manages performance review cycles, employee goals, and feedback. Managers can review employees and generate reports for a review cycle.

The application follows a layered architecture:

- **Controller Layer** – Handles REST APIs and request validation.
- **Service Layer** – Contains business logic for goals, reviews, and cycle summaries.
- **Repository Layer** – Handles database interaction using JPA.
- **Database Layer** – Stores employees, review cycles, goals, reviews, and feedback data.

The design keeps services stateless so that the application can scale horizontally when the load increases. Proper indexing is used in the database to improve query performance for reporting APIs.

## 3. System Design Question Answers

### 1. How would you scale the system to support 500 concurrent managers running reports?

To support around 500 concurrent managers during peak performance review periods, the system must scale both at the application and database levels.

At the application layer, my service can run behind a load balancer with multiple stateless instances. Since the APIs are stateless, horizontal scaling can be achieved by deploying additional instances.
Proper database connection pooling (for example HikariCP) should be configured to avoid exhausting database connections when many users generate reports simultaneously.

At the database level, proper indexing should be added on frequently queried fields such as `employee_id`, `cycle_id`, and `department`.
This helps reduce query execution time when the dataset grows.

For heavy reporting queries, pagination or asynchronous processing can be used so that the API remains responsive even when many managers request reports at the same time.

---

### 2. If `GET /cycles/{id}/summary` becomes slow at 100k+ reviews, what would you do?

If the cycle summary API becomes slow with large datasets, I will optimize the query.

I will create indexes on columns like `reviews.cycle_id` and `goals.cycle_id` so the database scans only relevant rows. Instead of calculating metrics such as average rating, top performer,
and goal completion count on every request, a pre-aggregated summary table can be maintained.

This summary table can be updated whenever a review or goal changes, making the summary API faster because it reads already computed data instead of calculating everything in real time.

---

### 3. Where would you add caching, and what would you cache?

I will add caching at the service layer to reduce database load for frequently requested data.

The best candidates for caching include:
- `GET /cycles/{id}/summary`
- `GET /employees/{id}/reviews`
- Employee lists filtered by department

Cycle summaries are accessed frequently but updated less often, which makes them ideal for caching with a short expiration time (for example 5–10 minutes).

For distributed systems, a caching solution such as Redis can be used so multiple application instances share the same cached data. Cache invalidation should occur when a new review is submitted or when goal statuses change to ensure that users always see updated information.
