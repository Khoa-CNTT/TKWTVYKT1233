package com.kltn.medicalwebsite.repository;

import com.kltn.medicalwebsite.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
