package com.tailoring.controller;

import com.tailoring.entity.Rating;
import com.tailoring.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public Rating createRating(
            @RequestParam Long customerId,
            @RequestParam Long tailorId,
            @RequestParam Integer rating,
            @RequestParam(required = false) String comment) {

        return ratingService.saveRating(
                customerId,
                tailorId,
                rating,
                comment
        );
    }

    @GetMapping("/tailor/{tailorId}")
    public List<Rating> getTailorRatings(
            @PathVariable Long tailorId) {

        return ratingService.getTailorRatings(tailorId);
    }
}