package com.phoneshop.controllers;

import com.phoneshop.entities.Warehouse;
import com.phoneshop.repositories.WarehouseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class WarehouseController {

    private final Logger log = (Logger) LoggerFactory.getLogger(LabController.class);
    private final WarehouseRepository warehouseRepository;

    public WarehouseController(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @GetMapping(value = {"/api/warehouses", "/api/warehouses/"})
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @GetMapping(value = {"/api/warehouses/{id}", "/api/warehouses/{id}/"})
    public ResponseEntity<Warehouse> findById(@PathVariable Long id) {

        Optional<Warehouse> warehouseOpt = warehouseRepository.findById(id);

        return warehouseOpt.isPresent() ?
                ResponseEntity.ok(warehouseOpt.get())
                : ResponseEntity.notFound().build();

    }

    @PostMapping(value = {"/api/warehouses/{warehouse}",
            "/api/warehouses/{warehouse}/"})
    public ResponseEntity<Warehouse> create(@RequestBody Warehouse warehouse) {

        if (warehouse.getWarehouseId() != null) {

            log.warn("Trying to create a warehouse with id");
            return ResponseEntity.badRequest().build();

        }

        Warehouse result = warehouseRepository.save(warehouse);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = {"/api/warehouses/{warehouse}",
            "/api/warehouses/{warehouse}/"})
    public ResponseEntity<Warehouse> update(@RequestBody Warehouse warehouse) {

        if (warehouse.getWarehouseId() == null) {

            log.warn("Trying to update a warehouse without id");
            return ResponseEntity.badRequest().build();

        }

        if (!warehouseRepository.existsById(warehouse.getWarehouseId())) {

            log.warn("Trying to update a non existent warehouse");
            return ResponseEntity.notFound().build();

        }

        Warehouse result = warehouseRepository.save(warehouse);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping(value = {"/api/warehouses/{id}", "/api/warehouses/{id}/"})
    public ResponseEntity<Warehouse> deleteById(@PathVariable Long id) {

        if (!warehouseRepository.existsById(id)) {

            log.warn("Trying to delete a non existent warehouse");
            return ResponseEntity.notFound().build();

        }

        warehouseRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/api/warehouses", "/api/warehouses/"})
    public ResponseEntity<Warehouse> deleteAll() {

        log.info("Deleting all warehouses...");
        warehouseRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
