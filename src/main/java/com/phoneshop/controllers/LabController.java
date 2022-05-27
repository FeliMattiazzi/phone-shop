package com.phoneshop.controllers;

import com.phoneshop.entities.Lab;
import com.phoneshop.repositories.LabRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class LabController {

    private final LabRepository labRepository;

    public LabController(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    @GetMapping(value = {"/api/labs", "/api/labs/"})
    public ResponseEntity<List<Lab>> findAll() {
        return ResponseEntity.ok().body(labRepository.findAll());
    }

    @GetMapping(value = {"/api/labs/{id}", "/api/labs/{id}/"})
    public ResponseEntity<Lab> findById(@PathVariable Long id) {

        Optional<Lab> labOpt = labRepository.findById(id);

        return labOpt.isPresent() ?
                ResponseEntity.ok(labOpt.get())
                : ResponseEntity.notFound().build();

    }

    @PostMapping(value = {"/api/labs", "/api/labs/"})
    public ResponseEntity<Lab> create(@RequestBody Lab lab){

        if (lab.getLabId() != null){

            log.warn("Trying to create a lab with id");
            return ResponseEntity.badRequest().build();

        }

        Lab result = labRepository.save(lab);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = {"/api/labs", "/api/labs/"})
    public ResponseEntity<Lab> update(@RequestBody Lab lab) {

        if (lab.getLabId() == null) {

            log.warn("Trying to update a non existent lab");
            return ResponseEntity.badRequest().build();

        }

        if (!labRepository.existsById(lab.getLabId())){

            log.warn("Trying to update a non existent lab");
            return ResponseEntity.notFound().build();

        }

        Lab result = labRepository.save(lab);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping(value = {"/api/labs/{id}", "/api/labs/{id}/"})
    public ResponseEntity<Lab> deleteById(@PathVariable Long id){

        if(!labRepository.existsById(id)) {

            log.warn("Trying to delete a non existent lab");
            return ResponseEntity.notFound().build();

        }

        labRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/api/labs", "/api/labs/"})
    public ResponseEntity<Lab> deleteAll() {

        log.info("Deleting all labs...");
        labRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
