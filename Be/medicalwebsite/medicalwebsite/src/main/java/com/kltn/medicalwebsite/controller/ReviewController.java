package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Review;
import com.kltn.medicalwebsite.request.ReviewRequest;
import com.kltn.medicalwebsite.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("/assess")
    public ResponseEntity<Review> assessDoctor(@RequestBody ReviewRequest reviewRequest){
        Review review = reviewService.assess(reviewRequest);
        if(review != null){
            return  new ResponseEntity<>(review, HttpStatus.CREATED);
        }else {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{doctorId}")
    public  ResponseEntity<List<Review>> listReivewByDoctor(@PathVariable("doctorId")Long doctorId){
        List<Review> reviews = reviewService.findAllReviewByDoctorId(doctorId);
        if (reviews.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(reviews,HttpStatus.OK);
        }
    }
}

