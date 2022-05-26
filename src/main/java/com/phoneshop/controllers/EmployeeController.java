package com.phoneshop.controllers;

import com.phoneshop.entities.Employee;
import com.phoneshop.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = {"/api/employees", "/api/employees/"})
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping(value = {"/api/employees/{id}", "/api/employees/{id}/"})
    public ResponseEntity<Employee> findById(@PathVariable Long id) {

        Optional<Employee> employeeOpt = employeeRepository.findById(id);

        return  employeeOpt.isPresent() ?
                ResponseEntity.ok(employeeOpt.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping(value = {"/api/employees", "/api/employees/"})
    public ResponseEntity<Employee> create(@RequestBody Employee employee){

        if(employee.getEmployeeId() != null) {

            log.warn("Trying to create am employee with id");
            return ResponseEntity.badRequest().build();

        }

        Employee result = employeeRepository.save(employee);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = {"/api/employees", "/api/employees/"})
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {

        if (employee.getEmployeeId() == null) {

            log.warn("Trying to update a employee without id");
            return ResponseEntity.badRequest().build();

        }

        if (!employeeRepository.existsById(employee.getUserId())) {

            log.warn("Trying to update a non existent employee");
            return ResponseEntity.notFound().build();

        }

        Employee result = employeeRepository.save(employee);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping(value = {"/api/employees/{id}", "/api/employees/{id}/"})
    public ResponseEntity<Employee> deleteById(@PathVariable Long id) {

        if (!employeeRepository.existsById(id)) {

            log.warn("Trying to delete a non existent employee");
            return ResponseEntity.notFound().build();

        }

        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/api/employees", "/api/employees/"})
    public ResponseEntity<Employee> deleteAll() {

        log.info("Deleting all employees...");
        employeeRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
