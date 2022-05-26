package com.phoneshop.controllers;

import com.phoneshop.entities.Depository;
import com.phoneshop.repositories.DepositoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepositoryController {

    private final DepositoryRepository depositoryRepository;
    private final Logger log = (Logger) LoggerFactory.getLogger(LabController.class);

    public DepositoryController(DepositoryRepository depositoryRepository) {
        this.depositoryRepository = depositoryRepository;
    }

    @GetMapping(value = {"/api/depositories", "/api/depositories/"})
    public List<Depository> findAll() {
        return depositoryRepository.findAll();
    }

    @GetMapping(value = {"/api/depositories/{id}", "/api/depositories/{id}/"})
    public ResponseEntity<Depository> findById(@PathVariable Long id) {

        Optional<Depository> depositoryOpt = depositoryRepository.findById(id);
        return depositoryOpt.isPresent() ?
                ResponseEntity.ok(depositoryOpt.get())
                : ResponseEntity.notFound().build();

    }

    @PostMapping(value = {"/api/depositories/{depository}", "/api/depositories/{depository}/"})
    public ResponseEntity<Depository> create(@PathVariable Depository depository){

        if(depository.getDepositoryId() != null) {

            log.warn("Trying to create a depository with id");
            return ResponseEntity.badRequest().build();

        }

        Depository result = depositoryRepository.save(depository);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = {"/api/depositories/{depository}", "/api/depositories/{depositories}/"})
    public ResponseEntity<Depository> update(@RequestBody Depository depository) {

        if (depository.getDepositoryId() == null) {

            log.warn("Trying to update a depository without id");
            return ResponseEntity.badRequest().build();

        }

        if (!depositoryRepository.existsById(depository.getDepositoryId())) {

            log.warn("Trying to update a non existent depository");
            return ResponseEntity.badRequest().build();

        }

        Depository result = depositoryRepository.save(depository);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping(value = {"/api/depositories/{id}", "/api/depositories/{id}/"})
    public ResponseEntity<Depository> deleteById(@PathVariable Long id) {

        if (!depositoryRepository.existsById(id)) {
            log.warn("Trying to delete a non existent depository");
            return ResponseEntity.badRequest().build();
        }

        depositoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/api/depositories", "/api/depositories/"})
    public ResponseEntity<Depository> deleteAll() {

        log.info("Deleting all depositories...");
        depositoryRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
