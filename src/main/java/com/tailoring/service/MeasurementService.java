package com.tailoring.service;

import com.tailoring.entity.Customer;
import com.tailoring.entity.Measurement;
import com.tailoring.repository.CustomerRepository;
import com.tailoring.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final CustomerRepository customerRepository;

    public MeasurementService(MeasurementRepository measurementRepository,
                              CustomerRepository customerRepository) {
        this.measurementRepository = measurementRepository;
        this.customerRepository = customerRepository;
    }

    public Measurement saveMeasurement(Measurement measurement) {

        Customer customer = customerRepository.findById(
                measurement.getCustomer().getId()
        ).orElseThrow(() -> new RuntimeException("Customer not found"));

        measurement.setCustomer(customer);

        return measurementRepository.save(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Measurement updateMeasurement(Long id, Measurement measurement) {

        Measurement existingMeasurement = measurementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));

        Customer customer = customerRepository.findById(
                measurement.getCustomer().getId()
        ).orElseThrow(() -> new RuntimeException("Customer not found"));

        existingMeasurement.setCustomer(customer);
        existingMeasurement.setShoulder(measurement.getShoulder());
        existingMeasurement.setChest(measurement.getChest());
        existingMeasurement.setWaist(measurement.getWaist());
        existingMeasurement.setHip(measurement.getHip());
        existingMeasurement.setSleeve(measurement.getSleeve());
        existingMeasurement.setLength(measurement.getLength());

        return measurementRepository.save(existingMeasurement);
    }

    public void deleteMeasurement(Long id) {

        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));

        measurement.setHiddenFromTailor(true);

        measurementRepository.save(measurement);
    }
}