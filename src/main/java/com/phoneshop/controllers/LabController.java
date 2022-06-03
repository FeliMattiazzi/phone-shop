package com.phoneshop.controllers;

import com.phoneshop.entities.Lab;
import com.phoneshop.services.LabService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController @Slf4j
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

        Optional<Lab> labOpt = labService.findById(id);

        return labOpt.isPresent() ?
                ResponseEntity.ok(labOpt.get())
                : ResponseEntity.notFound().build();

    }


    @PostMapping
    public ResponseEntity<Lab> create(@RequestBody Lab lab){

        if (lab.getLabId() != null) {

            log.warn("Trying to create a lab with id");
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(labService.create(lab));
    }

    /*
    APLICAR EXCEPTION HADLER
     */

    @PutMapping
    public ResponseEntity<Lab> update(@RequestBody Lab lab) {

        if (lab.getLabId() != null) {

            log.warn("Trying to update a lab with id");
            return ResponseEntity.badRequest().build();

        }

        try {

            return ResponseEntity.ok(labService.update(lab));

        } catch (RuntimeException e) {

            log.warn(e.getMessage());
            return ResponseEntity.badRequest().build();

        }

    }

    @DeleteMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Lab> deleteById(@PathVariable Long id){

        try {

            labService.deleteById(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {

            log.warn(e.getMessage());
            return ResponseEntity.notFound().build();

        }

    }

    @DeleteMapping
    public ResponseEntity<Lab> deleteAll() {

        log.warn("Deleting all labs...");
        labService.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
