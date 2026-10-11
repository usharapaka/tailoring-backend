package com.tailoring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Tailor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String password;
    private String specialization;
    private String experience;

    // Tailor availability status
private String status = "Available";

// Tailor rating
private Double rating = 0.0;
private Integer ratingCount = 0;

    @OneToMany(mappedBy = "tailor")
    @JsonIgnore
    private List<Appointment> appointments;

    public Tailor() {
    }

    public Tailor(String name, String phone,
                  String email, String password,
                  String specialization, String experience) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.specialization = specialization;
        this.experience = experience;
        this.status = "Available";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
    
    
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRating() {
    return rating;
}

public void setRating(Double rating) {
    this.rating = rating;
}

public Integer getRatingCount() {
    return ratingCount;
}

public void setRatingCount(Integer ratingCount) {
    this.ratingCount = ratingCount;
}

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}