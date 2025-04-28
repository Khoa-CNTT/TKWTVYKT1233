package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Payment;
import com.kltn.medicalwebsite.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/appointment/{appointmentId}")
    public ResponseEntity<Payment> paymentAppointment(@PathVariable("appointmentId")Long id , @RequestParam("amount")Double amount){
        Payment payment = paymentService.paymentAppointmentFoDoctorId(id,amount);
        return  new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
