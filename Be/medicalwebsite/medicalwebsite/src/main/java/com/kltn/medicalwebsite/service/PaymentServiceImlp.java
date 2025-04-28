package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.entity.Payment;
import com.kltn.medicalwebsite.exception.AppointmentException;
import com.kltn.medicalwebsite.repository.AppointmentRepository;
import com.kltn.medicalwebsite.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImlp implements PaymentService{

    private AppointmentRepository appointmentRepository;

    private PaymentRepository paymentRepository;

    public PaymentServiceImlp(AppointmentRepository appointmentRepository, PaymentRepository paymentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Payment paymentAppointmentFoDoctorId(Long appointment, Double amount) {
        Optional<Appointment> exsitAppointment = appointmentRepository.findById(appointment);
        if(exsitAppointment.isPresent()){
            Payment payment = new Payment();
            payment.setAppointment(exsitAppointment.get());
            payment.setAmount(amount);
            payment.setStatus("PENDING");
            return  paymentRepository.save(payment) ;
        }else {
            throw  new AppointmentException("can't pay cause appointment not found with id :"+appointment);
        }

    }

    @Override
    public Payment findPaymentById(Long id) {
        Optional<Payment> existAppointment = paymentRepository.findById(id);
        if(existAppointment.isPresent()){
            return  existAppointment.get();
        }
        throw  new RuntimeException("payment not found with id :"+id);
    }
}
