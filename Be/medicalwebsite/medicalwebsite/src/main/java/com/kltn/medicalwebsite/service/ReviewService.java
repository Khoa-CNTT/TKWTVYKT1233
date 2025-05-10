package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Review;
import com.kltn.medicalwebsite.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    Review assess(ReviewRequest review);

    List<Review> findAllReviewByDoctorId(Long doctorId);
}
