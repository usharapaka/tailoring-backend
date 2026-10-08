package com.tailoring.controller;

import com.tailoring.entity.Tailor;
import com.tailoring.service.TailorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tailors")
public class TailorController {

    private final TailorService tailorService;

    public TailorController(TailorService tailorService) {
        this.tailorService = tailorService;
    }

    @PostMapping
    public Tailor createTailor(@RequestBody Tailor tailor) {
        return tailorService.saveTailor(tailor);
    }

    @GetMapping
    public List<Tailor> getAllTailors() {
        return tailorService.getAllTailors();
    }

    @PutMapping("/{id}")
    public Tailor updateTailor(
            @PathVariable Long id,
            @RequestBody Tailor tailor) {
        return tailorService.updateTailor(id, tailor);
    }

    @PutMapping("/{id}/status")
public Tailor updateStatus(
        @PathVariable Long id,
        @RequestParam String status) {

    return tailorService.updateStatus(id, status);
}

    @DeleteMapping("/{id}")
    public void deleteTailor(@PathVariable Long id) {
        tailorService.deleteTailor(id);
    }
}