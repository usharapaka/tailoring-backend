package com.tailoring.controller;

import com.tailoring.entity.Customer;
import com.tailoring.entity.Tailor;
import com.tailoring.repository.CustomerRepository;
import com.tailoring.repository.TailorRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CustomerRepository customerRepository;
    private final TailorRepository tailorRepository;

    public AuthController(
            CustomerRepository customerRepository,
            TailorRepository tailorRepository) {

        this.customerRepository = customerRepository;
        this.tailorRepository = tailorRepository;
    }

    // ================= CUSTOMER SIGN IN =================

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        String cleanEmail = email.trim().toLowerCase();

        Customer existingCustomer = customerRepository
                .findAll()
                .stream()
                .filter(customer ->
                        customer.getEmail() != null &&
                        customer.getEmail()
                                .equalsIgnoreCase(cleanEmail)
                )
                .findFirst()
                .orElse(null);

        if (existingCustomer == null) {
            return "Invalid email or password";
        }

        // Check the password saved during customer signup
        String savedPassword = existingCustomer.getPassword();

        if (savedPassword == null ||
                !savedPassword.equals(password)) {
            return "Invalid email or password";
        }

        return "Login successful";
    }

    // ================= TAILOR SIGN IN =================

    @PostMapping("/tailor-login")
    public String tailorLogin(@RequestParam String email,
                              @RequestParam String password) {

        String cleanEmail = email.trim().toLowerCase();

        Tailor existingTailor = tailorRepository
                .findByEmail(cleanEmail)
                .orElse(null);

        if (existingTailor == null) {
            return "Invalid email or password";
        }

        if (existingTailor.getPassword() == null ||
                !existingTailor.getPassword().equals(password)) {
            return "Invalid email or password";
        }

        return "Login successful";
    }

    // ================= TAILOR SIGN UP =================

    @PostMapping("/tailor-signup")
    public Tailor tailorSignup(@RequestBody Tailor tailor) {

        String cleanEmail = tailor.getEmail().trim().toLowerCase();

        boolean emailExists = tailorRepository
                .findByEmail(cleanEmail)
                .isPresent();

        if (emailExists) {
            throw new RuntimeException("Email already registered");
        }

        tailor.setEmail(cleanEmail);

        return tailorRepository.save(tailor);
    }
}