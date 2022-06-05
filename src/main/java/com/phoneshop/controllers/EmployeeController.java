package com.phoneshop.controllers;

import com.phoneshop.entities.Employee;
import com.phoneshop.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api", "/api/"})
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"/users", "/users/"})
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping(value = {"/users/{id}", "/users/{id}/"})
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping(value = {"/signup", "/signup/"})
    public ResponseEntity<Employee> signIn(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @PutMapping(value = {"/change-username", "/change-username/"})
    public ResponseEntity<Employee> changeUsername(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateUsername(employee));
    }

    @PutMapping(value = {"/change-password", "/change-password/"})
    public ResponseEntity<Employee> changePassword(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updatePassword(employee));
    }

    @DeleteMapping(value = {"/users/{id}", "/users/{id}/"})
    public ResponseEntity<Employee> deleteById(@PathVariable Long id) {

        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/users, /users/"})
    public ResponseEntity<Employee> deleteAll() {

        employeeService.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
