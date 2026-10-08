package com.tailoring.controller;

import com.tailoring.entity.Admin;
import com.tailoring.repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // ================= ADMIN SIGN UP =================

    @PostMapping("/signup")
    public Admin adminSignup(@RequestBody Admin admin) {

        String cleanEmail = admin.getEmail().trim().toLowerCase();

        boolean emailExists = adminRepository
                .findByEmail(cleanEmail)
                .isPresent();

        if (emailExists) {
            throw new RuntimeException("Admin email already registered");
        }

        admin.setEmail(cleanEmail);

        return adminRepository.save(admin);
    }

    // ================= ADMIN LOGIN =================

    @PostMapping("/login")
    public String adminLogin(@RequestParam String email,
                             @RequestParam String password) {

        String cleanEmail = email.trim().toLowerCase();

        Admin existingAdmin = adminRepository
                .findByEmail(cleanEmail)
                .orElse(null);

        if (existingAdmin == null) {
            return "Invalid admin credentials";
        }

        if (existingAdmin.getPassword() == null ||
                !existingAdmin.getPassword().equals(password)) {
            return "Invalid admin credentials";
        }

        return "Login successful";
    }
}