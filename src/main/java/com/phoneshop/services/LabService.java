package com.phoneshop.services;

import com.phoneshop.entities.Lab;
import com.phoneshop.exceptions.BadRequestException;
import com.phoneshop.exceptions.NotFoundException;
import com.phoneshop.repositories.LabRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j @RequiredArgsConstructor
public class LabService {

    @Autowired
    private final LabRepository labRepository;

    public List<Lab> findAll() {
        return labRepository.findAll();
    }

    public Lab findById(Long id) throws NotFoundException {

        Optional<Lab> labOpt = labRepository.findById(id);

        if (!labOpt.isPresent()) {
            throw new NotFoundException();
        }

        return labOpt.get();

    }

    public Lab create(Lab lab) throws BadRequestException {
        if (lab.getLabId() != null) {
            throw new BadRequestException("Trying to create a lab with id");
        }

        return labRepository.save(lab);

    }

    public Lab update(Lab lab) throws NotFoundException, BadRequestException {

        if (lab.getLabId() == null) {
            throw new BadRequestException("Trying to update a lab without id");
        }

        if (!labRepository.existsById(lab.getLabId())) {
            throw new NotFoundException("Trying to update a " +
                    "non-existent lab");
        }

        return labRepository.save(lab);

    }


    public void deleteById(Long id) throws NotFoundException {

        if(!labRepository.existsById(id)) {

            throw new NotFoundException("Trying to delete a " +
                    "non-existent lab");

        }

        labRepository.deleteById(id);

    }

    public void deleteAll() {

        log.info("Deleting all labs...");
        labRepository.deleteAll();

    }

}
