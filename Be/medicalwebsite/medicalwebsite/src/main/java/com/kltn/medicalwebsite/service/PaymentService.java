package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Payment;

public interface PaymentService {


    Payment paymentAppointmentFoDoctorId(Long appointment,Double amount);

    Payment findPaymentById(Long id);


}
