package com.hivel.tracker.repository;

import com.hivel.tracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(""" 
          SELECT e FROM Employee e
          JOIN PerformanceReview r ON e.id=r.employee.id
          WHERE e.department=:dept
          GROUP BY e.id
          HAVING AVG(r.rating)>=:rating
          """)
    List<Employee> findByDepartmentAndMinRating(String dept, Double rating);
}
