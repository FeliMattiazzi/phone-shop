package com.phoneshop.services;

import com.phoneshop.entities.Depository;
import com.phoneshop.exceptions.BadRequestException;
import com.phoneshop.exceptions.NotFoundException;
import com.phoneshop.repositories.DepositoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j @RequiredArgsConstructor
public class DepositoryService {

    @Autowired
    private final DepositoryRepository depositoryRepository;

    public List<Depository> findAll() {
        return depositoryRepository.findAll();
    }

    public Depository findById(Long id) throws NotFoundException {

        Optional<Depository> depositoryOpt = depositoryRepository.findById(id);

        if (!depositoryOpt.isPresent()) {
            throw new NotFoundException();
        }

        return depositoryOpt.get();

    }

    public Depository create(Depository depository) throws BadRequestException {

        if(depository.getDepositoryId() != null) {
            throw new BadRequestException("Trying to create a depository with id");
        }

        return depositoryRepository.save(depository);

    }

    public Depository update(Depository depository) throws BadRequestException, NotFoundException {

        if (depository.getDepositoryId() == null) {
            throw new BadRequestException("Trying to update a depository without id");
        }

        if (!depositoryRepository.existsById(depository.getDepositoryId())) {
            throw new NotFoundException("Trying to update a " +
                    "non-existent depository");
        }

        return depositoryRepository.save(depository);

    }

    public void deleteById(Long id) throws NotFoundException {

        if (!depositoryRepository.existsById(id)) {
            throw new NotFoundException("Trying to delete a " +
                    "non-existent depository");
        }

        depositoryRepository.deleteById(id);

    }

    public void deleteAll() {

        log.warn("Deleting all depositories...");
        depositoryRepository.deleteAll();

    }

}
