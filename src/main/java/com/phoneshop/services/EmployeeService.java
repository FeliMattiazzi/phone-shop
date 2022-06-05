package com.phoneshop.services;

import com.phoneshop.entities.Employee;
import com.phoneshop.exceptions.BadRequestException;
import com.phoneshop.exceptions.NotFoundException;
import com.phoneshop.exceptions.UsernameAlreadyTakenException;
import com.phoneshop.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) throws NotFoundException {

        Optional<Employee> userOpt = employeeRepository.findById(id);

        if (!userOpt.isPresent())
            throw new NotFoundException("User does not exists");

        return userOpt.get();

    }

    public Employee create(Employee employee) throws BadRequestException, UsernameAlreadyTakenException {

        if (employee.getEmployeeId() != null)
            throw new BadRequestException("Trying to create a user with id");

        if (employeeRepository.existsByUsername(employee.getUsername()))
            throw new UsernameAlreadyTakenException();

        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);

        return employeeRepository.save(employee);

    }

    public Employee updateUsername(Employee employee) throws BadRequestException, NotFoundException {

        if (employee.getEmployeeId() == null)
            throw new BadRequestException("Trying to update a user without id");

        if (!employeeRepository.existsById(employee.getEmployeeId()))
            throw new NotFoundException("Trying to update a non-existent user");

        return employeeRepository.save(employee);

    }

    public Employee updatePassword(Employee employee) throws BadRequestException, NotFoundException {

        if (employee.getEmployeeId() == null)
            throw new BadRequestException("Trying to update a user without id");

        if (!employeeRepository.existsById(employee.getEmployeeId()))
            throw new NotFoundException("Trying to update a non-existent user");

        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);

        return employeeRepository.save(employee);

    }

    public void deleteById(Long id) throws NotFoundException {

        if (!employeeRepository.existsById(id))
            throw new NotFoundException("Trying to delete a non-existent user");

        employeeRepository.deleteById(id);

    }

    public void deleteAll() {

        log.info("Deleting all users...");
        employeeRepository.deleteAll();

    }

}
