-- Employees
CREATE TABLE employees (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   department VARCHAR(100)
 );

 -- Review Cycles
 CREATE TABLE review_cycles(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   start_date DATE NOT_NULL,
   end_date DATE NOT_NULL
 );

 -- Goals
 CREATE TABLE goals (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  status VARCHAR(50) NOT NULL,
  employee_id BIGINT NOT NULL,
  cycle_id BIGINT NOT NULL,

   CONSTRAINT fk_goal_employee
     FOREIGN KEY (employee_id)
     REFERENCES employees(id),

   CONSTRAINT fk_goal_cycle
     FOREIGN KEY (cycle_id)
     REFERENCES review_cycles(id)
 );

 -- Reviews
 -- NOTE: Multiple reviews allowed for the same employee in the same cycle
 CREATE TABLE reviews(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   employee_id BIGINT NOT NULL,
   cycle_id BIGINT NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

   CONSTRAINT fk_review_employee
     FOREIGN KEY (employee_id)
     REFERENCES employees(id),

   CONSTRAINT fk_review_cycle
      FOREIGN KEY (cycle_id)
      REFERENCES review_cycles(id)

 );

 -- Indexes for faster filtering queries
 CREATE INDEX idx_goals_employee
 ON goals(employee_id);

 CREATE INDEX idx_goals_cycle
 ON goals(cycle_id);

 CREATE INDEX idx_reviews_employee
 ON reviews(employee_id);

 CREATE INDEX idx_reviews_cycle
 ON reviews(cycle_id);