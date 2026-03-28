package com.hivel.tracker.controller;

import com.hivel.tracker.dto.EmployeeRequest;
import com.hivel.tracker.model.Employee;
import com.hivel.tracker.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * This method is used to create an employee
     * @param employee it represents the employee data
     * @return it returns the employee instance once employee is saved successfully
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employee){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employee));
    }

    /**
     * This method is used to filter an employee on the basis of department and minRating
     * @param department it is the department in which employee work
     * @param minRating it represents min rating
     * @return
     */
    @GetMapping
    public List<Employee> filterEmployees(
            @RequestParam String department,
            @RequestParam Double minRating){
        return employeeService.filterEmployees(department, minRating);
    }

}
