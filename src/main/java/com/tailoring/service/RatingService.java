package com.tailoring.service;

import com.tailoring.entity.Customer;
import com.tailoring.entity.Rating;
import com.tailoring.entity.Tailor;
import com.tailoring.repository.CustomerRepository;
import com.tailoring.repository.RatingRepository;
import com.tailoring.repository.TailorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final CustomerRepository customerRepository;
    private final TailorRepository tailorRepository;

    public RatingService(
            RatingRepository ratingRepository,
            CustomerRepository customerRepository,
            TailorRepository tailorRepository) {

        this.ratingRepository = ratingRepository;
        this.customerRepository = customerRepository;
        this.tailorRepository = tailorRepository;
    }

    public Rating saveRating(
            Long customerId,
            Long tailorId,
            Integer rating,
            String comment) {

        if (rating == null || rating < 1 || rating > 5) {
            throw new RuntimeException(
                    "Rating must be between 1 and 5"
            );
        }

        boolean alreadyRated =
                ratingRepository.existsByCustomerIdAndTailorId(
                        customerId,
                        tailorId
                );

        if (alreadyRated) {
            throw new RuntimeException(
                    "You have already rated this tailor"
            );
        }

        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        Tailor tailor = tailorRepository
                .findById(tailorId)
                .orElseThrow(() ->
                        new RuntimeException("Tailor not found"));

        Rating newRating = new Rating(
                rating,
                comment,
                customer,
                tailor
        );

        Rating savedRating =
                ratingRepository.save(newRating);

        updateTailorRating(tailor);

        return savedRating;
    }

    private void updateTailorRating(Tailor tailor) {

        List<Rating> ratings =
                ratingRepository.findByTailorId(tailor.getId());

        if (ratings.isEmpty()) {
            tailor.setRating(0.0);
            tailor.setRatingCount(0);
        } else {

            double total = ratings.stream()
                    .mapToInt(Rating::getRating)
                    .sum();

            double average = total / ratings.size();

            average = Math.round(average * 10.0) / 10.0;

            tailor.setRating(average);
            tailor.setRatingCount(ratings.size());
        }

        tailorRepository.save(tailor);
    }

    public List<Rating> getTailorRatings(Long tailorId) {

        return ratingRepository.findByTailorId(tailorId);
    }
}