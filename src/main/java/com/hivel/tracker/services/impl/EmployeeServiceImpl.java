package com.hivel.tracker.services.impl;

import com.hivel.tracker.dto.EmployeeRequest;
import com.hivel.tracker.model.Employee;
import com.hivel.tracker.repository.EmployeeRepository;
import com.hivel.tracker.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * This method is used to create an employee
     * @param request
     * @return
     */
    @Override
    public Employee createEmployee(EmployeeRequest request) {
        Employee emp = new Employee();
        emp.setName(request.getName());
        emp.setDepartment(request.getDepartment());
        emp.setRole(request.getRole());
        emp.setJoiningDate(request.getJoiningDate());
        return employeeRepository.save(emp);
    }

    /**
     * This method is used to filter an employees on the basis of department and minrating
     * @param department
     * @param minRating
     * @return
     */
    @Override
    public List<Employee> filterEmployees(String department, Double minRating) {
        return employeeRepository.findByDepartmentAndMinRating(department, minRating);
    }
}
