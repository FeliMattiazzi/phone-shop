package com.phoneshop.controllers;

import com.phoneshop.entities.Movement;
import com.phoneshop.repositories.MovementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovementController {

    private final Logger log = (Logger) LoggerFactory.getLogger(LabController.class);
    private final MovementRepository movementRepository;

    public MovementController(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @GetMapping(value = {"/api/movements", "/api/movements/"})
    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    @GetMapping(value = {"/api/movements/{id}", "/api/movements/{id}/"})
    public ResponseEntity<Movement> findById(@PathVariable Long id) {

        Optional<Movement> movementOpt = movementRepository.findById(id);

        return movementOpt.isPresent() ?
                ResponseEntity.ok(movementOpt.get())
                : ResponseEntity.notFound().build();

    }

    @PostMapping(value = {"/api/movements", "/api/movements/"})
    public ResponseEntity<Movement> create(@RequestBody Movement movement) {

        if (movement.getMovementId() != null) {

            log.warn("Trying to create a movement with id");
            return ResponseEntity.badRequest().build();

        }

        Movement result = movementRepository.save(movement);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = {"/api/movements/{movement}", "/api/movements/{movement}/"})
    public ResponseEntity<Movement> update(@RequestBody Movement movement) {

        if (movement.getMovementId() == null) {

            log.warn("Trying to update a movement without id");
            return ResponseEntity.badRequest().build();

        }

        if (!movementRepository.existsById(movement.getMovementId())) {

            log.warn("Trying to update a non existent movement");
            return ResponseEntity.notFound().build();

        }

        Movement result = movementRepository.save(movement);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping(value = {"/api/movements/{id}", "/api/movements/{id}/"})
    public ResponseEntity<Movement> deleteById(@PathVariable Long id) {

        if (!movementRepository.existsById(id)) {

            log.warn("Trying to delete a non existent movement");
            return ResponseEntity.notFound().build();

        }

        movementRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/api/movements", "/api/movements/"})
    public ResponseEntity<Movement> deleteAll() {

        log.info("Deleting all movements...");
        movementRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
