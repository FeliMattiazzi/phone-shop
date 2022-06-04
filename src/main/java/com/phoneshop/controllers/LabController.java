package com.phoneshop.controllers;

import com.phoneshop.entities.Lab;
import com.phoneshop.services.LabService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/labs", "/api/labs/"})
public class LabController {

    private final LabService labService;

    public LabController(LabService labService) {
        this.labService = labService;
    }

    @GetMapping
    public ResponseEntity<List<Lab>> findAll() {
        return ResponseEntity.ok(labService.findAll());
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Lab> findById(@PathVariable Long id) {
        return ResponseEntity.ok(labService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Lab> create(@RequestBody Lab lab){
        return ResponseEntity.ok(labService.create(lab));
    }

    @PutMapping
    public ResponseEntity<Lab> update(@RequestBody Lab lab) {
        return ResponseEntity.ok(labService.update(lab));
    }

    @DeleteMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Lab> deleteById(@PathVariable Long id) {

        labService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<Lab> deleteAll() {

        labService.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
