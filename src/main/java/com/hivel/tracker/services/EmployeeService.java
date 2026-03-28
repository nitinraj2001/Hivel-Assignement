package com.hivel.tracker.services;

import com.hivel.tracker.dto.EmployeeRequest;
import com.hivel.tracker.model.Employee;
import com.hivel.tracker.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee createEmployee(EmployeeRequest request);
    List<Employee> filterEmployees(String department, Double minRating);
}
