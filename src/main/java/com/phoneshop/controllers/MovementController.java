package com.phoneshop.controllers;

import com.phoneshop.entities.Movement;
import com.phoneshop.repositories.MovementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = {"/api/movements", "/api/movements/"})
public class MovementController {

    private final MovementRepository movementRepository;

    public MovementController(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @GetMapping
    public ResponseEntity<List<Movement>> findAll() {
        return ResponseEntity.ok().body(movementRepository.findAll());
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Movement> findById(@PathVariable Long id) {

        Optional<Movement> movementOpt = movementRepository.findById(id);

        return movementOpt.isPresent() ?
                ResponseEntity.ok(movementOpt.get())
                : ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Movement> create(@RequestBody Movement movement) {

        if (movement.getMovementId() != null) {

            log.warn("Trying to create a movement with id");
            return ResponseEntity.badRequest().build();

        }

        Movement result = movementRepository.save(movement);
        return ResponseEntity.ok(result);

    }

    @PutMapping
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

    @DeleteMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Movement> deleteById(@PathVariable Long id) {

        if (!movementRepository.existsById(id)) {

            log.warn("Trying to delete a non existent movement");
            return ResponseEntity.notFound().build();

        }

        movementRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<Movement> deleteAll() {

        log.info("Deleting all movements...");
        movementRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
