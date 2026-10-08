package com.tailoring.repository;

import com.tailoring.entity.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TailorRepository extends JpaRepository<Tailor, Long> {

    Optional<Tailor> findByEmail(String email);
}