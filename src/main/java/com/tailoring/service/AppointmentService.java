package com.tailoring.service;

import com.tailoring.entity.Appointment;
import com.tailoring.entity.Customer;
import com.tailoring.entity.Tailor;
import com.tailoring.repository.AppointmentRepository;
import com.tailoring.repository.CustomerRepository;
import com.tailoring.repository.TailorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final TailorRepository tailorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              CustomerRepository customerRepository,
                              TailorRepository tailorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.tailorRepository = tailorRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {

        Customer customer = customerRepository.findById(
                appointment.getCustomer().getId()
        ).orElseThrow(() -> new RuntimeException("Customer not found"));

        Tailor tailor = tailorRepository.findById(
                appointment.getTailor().getId()
        ).orElseThrow(() -> new RuntimeException("Tailor not found"));

        appointment.setCustomer(customer);
        appointment.setTailor(tailor);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByTailor(Long tailorId) {
    return appointmentRepository.findByTailorId(tailorId);
}

    public Appointment updateAppointment(Long id, Appointment appointment) {

        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Customer customer = customerRepository.findById(
                appointment.getCustomer().getId()
        ).orElseThrow(() -> new RuntimeException("Customer not found"));

        Tailor tailor = tailorRepository.findById(
                appointment.getTailor().getId()
        ).orElseThrow(() -> new RuntimeException("Tailor not found"));

        existingAppointment.setCustomer(customer);
        existingAppointment.setTailor(tailor);
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
        existingAppointment.setStatus(appointment.getStatus());

        return appointmentRepository.save(existingAppointment);
    }

   public void deleteAppointment(Long id) {

    Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found"));

    appointment.setHiddenFromTailor(true);

    appointmentRepository.save(appointment);
}
}