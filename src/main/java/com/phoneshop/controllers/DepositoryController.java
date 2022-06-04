package com.phoneshop.controllers;

import com.phoneshop.entities.Depository;
import com.phoneshop.services.DepositoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/depositories", "/api/depositories/"})
public class DepositoryController {

    private final DepositoryService depositoryService;

    public DepositoryController(DepositoryService depositoryService) {
        this.depositoryService = depositoryService;
    }

    @GetMapping
    public ResponseEntity<List<Depository>> findAll() {
        return ResponseEntity.ok(depositoryService.findAll());
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Depository> findById(@PathVariable Long id) {
        return ResponseEntity.ok(depositoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Depository> create(@RequestBody Depository depository){
        return ResponseEntity.ok(depositoryService.create(depository));
    }

    @PutMapping
    public ResponseEntity<Depository> update(@RequestBody Depository depository) {
        return ResponseEntity.ok(depositoryService.update(depository));
    }

    @DeleteMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Depository> deleteById(@PathVariable Long id) {

        depositoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<Depository> deleteAll() {

        depositoryService.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
