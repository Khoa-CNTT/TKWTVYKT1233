package com.kltn.medicalwebsite.repository;

import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findFirstByAppointment(Appointment appointment);
}
