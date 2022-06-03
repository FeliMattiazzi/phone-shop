package com.phoneshop.services;

import com.phoneshop.entities.Lab;
import com.phoneshop.exceptions.NotFoundException;
import com.phoneshop.repositories.LabRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabService {

    private final LabRepository labRepository;

    public LabService(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    public List<Lab> findAll() {
        return labRepository.findAll();
    }

    public Optional<Lab> findById(Long id) {
        return labRepository.findById(id);
    }

    public Lab create(Lab lab) {
        return labRepository.save(lab);
    }

    public Lab update(Lab lab) throws NotFoundException {

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
        labRepository.deleteAll();
    }

}
