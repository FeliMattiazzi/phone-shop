package com.phoneshop.controllers;

import com.phoneshop.entities.AppUser;
import com.phoneshop.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api", "/api/"})
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(value = {"/users", "/users/"})
    public ResponseEntity<List<AppUser>> findAll() {
        return ResponseEntity.ok(appUserService.findAll());
    }

    @GetMapping(value = {"/users/{id}", "/users/{id}/"})
    public ResponseEntity<AppUser> findById(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.findById(id));
    }

    @PostMapping(value = {"/signup", "/signup/"})
    public ResponseEntity<AppUser> signIn(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.create(appUser));
    }

    @PutMapping(value = {"/update-user", "/update-user/"})
    public ResponseEntity<AppUser> changeUsername(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.update(appUser));
    }

    @DeleteMapping(value = {"/users/{id}", "/users/{id}/"})
    public ResponseEntity<AppUser> deleteById(@PathVariable Long id) {

        appUserService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = {"/users, /users/"})
    public ResponseEntity<AppUser> deleteAll() {

        appUserService.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
