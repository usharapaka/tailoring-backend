package com.tailoring.service;

import com.tailoring.entity.Tailor;
import com.tailoring.repository.TailorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailorService {

    private final TailorRepository tailorRepository;

    public TailorService(TailorRepository tailorRepository) {
        this.tailorRepository = tailorRepository;
    }

    public Tailor saveTailor(Tailor tailor) {

        // New tailor default status
        if (tailor.getStatus() == null ||
                tailor.getStatus().trim().isEmpty()) {

            tailor.setStatus("Available");
        }

        return tailorRepository.save(tailor);
    }

    public List<Tailor> getAllTailors() {
        return tailorRepository.findAll();
    }

    public Tailor updateTailor(Long id, Tailor tailor) {

        Tailor existingTailor = tailorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tailor not found"));

        existingTailor.setName(tailor.getName());
        existingTailor.setPhone(tailor.getPhone());
        existingTailor.setEmail(tailor.getEmail());
        existingTailor.setSpecialization(tailor.getSpecialization());
        existingTailor.setExperience(tailor.getExperience());

        // Update status
        if (tailor.getStatus() != null &&
                !tailor.getStatus().trim().isEmpty()) {

            existingTailor.setStatus(tailor.getStatus());
        }

        // Password is changed only when a new password is actually provided
        if (tailor.getPassword() != null &&
                !tailor.getPassword().trim().isEmpty()) {

            existingTailor.setPassword(tailor.getPassword());
        }

        return tailorRepository.save(existingTailor);
    }
  
 public Tailor updateStatus(Long id, String status) {

    Tailor existingTailor = tailorRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Tailor not found"));

    existingTailor.setStatus(status);

    return tailorRepository.save(existingTailor);
}

    public void deleteTailor(Long id) {
        tailorRepository.deleteById(id);
    }
}