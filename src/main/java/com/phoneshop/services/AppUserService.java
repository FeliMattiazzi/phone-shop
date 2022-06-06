package com.phoneshop.services;

import com.phoneshop.entities.AppUser;
import com.phoneshop.exceptions.BadRequestException;
import com.phoneshop.exceptions.NotFoundException;
import com.phoneshop.exceptions.UsernameAlreadyTakenException;
import com.phoneshop.repositories.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    public AppUser findById(Long id) throws NotFoundException {

        Optional<AppUser> userOpt = appUserRepository.findById(id);

        if (!userOpt.isPresent())
            throw new NotFoundException("User does not exists");

        return userOpt.get();

    }

    public AppUser create(AppUser appUser) throws BadRequestException, UsernameAlreadyTakenException {

        if (appUser.getUserId() != null)
            throw new BadRequestException("Trying to create a user with id");

        if (appUserRepository.existsByUsername(appUser.getUsername()))
            throw new UsernameAlreadyTakenException();

        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        return appUserRepository.save(appUser);

    }

    public AppUser update(AppUser appUser) throws BadRequestException, NotFoundException {

        if (appUser.getUserId() == null)
            throw new BadRequestException("Trying to update a user without id");

        if (!appUserRepository.existsById(appUser.getUserId()))
            throw new NotFoundException("Trying to update a non-existent user");

        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        return appUserRepository.save(appUser);

    }

    public void deleteById(Long id) throws NotFoundException {

        if (!appUserRepository.existsById(id))
            throw new NotFoundException("Trying to delete a non-existent user");

        appUserRepository.deleteById(id);

    }

    public void deleteAll() {

        log.info("Deleting all users...");
        appUserRepository.deleteAll();

    }

}
