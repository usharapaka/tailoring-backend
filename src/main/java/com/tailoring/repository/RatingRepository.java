package com.tailoring.repository;

import com.tailoring.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByTailorId(Long tailorId);

    boolean existsByCustomerIdAndTailorId(
            Long customerId,
            Long tailorId
    );
}