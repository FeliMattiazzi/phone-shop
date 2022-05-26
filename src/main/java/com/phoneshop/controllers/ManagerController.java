package com.phoneshop.controllers;

import com.phoneshop.entities.Manager;
import com.phoneshop.repositories.ManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {

    private final Logger log = (Logger) LoggerFactory.getLogger(LabController.class);
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping(value = {"/api/managers", "/api/managers/"})
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @GetMapping(value = {"/api/managers/{id}", "/api/managers/{id}/"})
    public ResponseEntity<Manager> findById(@PathVariable Long id) {

        Optional<Manager> managerOpt = managerRepository.findById(id);

        return managerOpt.isPresent() ?
                ResponseEntity.ok(managerOpt.get())
                : ResponseEntity.notFound().build();

    }

    @PostMapping(value = {"/api/managers", "/api/managers/"})
    public ResponseEntity<Manager> create(@RequestBody Manager manager) {

        if(manager.getManagerId() != null) {

            log.warn("Trying to create a manager with id");
            return ResponseEntity.badRequest().build();

        }

        Manager result = managerRepository.save(manager);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = {"/api/managers", "/api/managers/"})
    public ResponseEntity<Manager> update(@RequestBody Manager manager) {

        if (manager.getManagerId() == null) {

            log.warn("Trying to update a manager without id");
            return ResponseEntity.badRequest().build();

        }

        if (!managerRepository.existsById(manager.getManagerId())) {

            log.warn("Trying to update a non existent manager");
            return ResponseEntity.notFound().build();

        }

        Manager result = managerRepository.save(manager);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping(value = {"/api/managers/{id}", "/api/managers/{id}/"})
    public ResponseEntity<Manager> deleteById(@PathVariable Long id) {

        if (!managerRepository.existsById(id)) {

            log.warn("Trying to delete a non existent manager");
            return ResponseEntity.notFound().build();

        }

        managerRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/api/managers", "/api/managers/"})
    public ResponseEntity<Manager> deleteAll() {

        log.info("Deleting all managers...");
        managerRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }


}
