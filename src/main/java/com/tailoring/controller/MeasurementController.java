package com.tailoring.controller;

import com.tailoring.entity.Measurement;
import com.tailoring.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping
    public Measurement createMeasurement(@RequestBody Measurement measurement) {
        return measurementService.saveMeasurement(measurement);
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @PutMapping("/{id}")
    public Measurement updateMeasurement(
            @PathVariable Long id,
            @RequestBody Measurement measurement) {
        return measurementService.updateMeasurement(id, measurement);
    }

    @DeleteMapping("/{id}")
    public void deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
    }
}