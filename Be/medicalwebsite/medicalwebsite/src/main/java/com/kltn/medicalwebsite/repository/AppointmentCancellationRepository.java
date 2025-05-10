package com.kltn.medicalwebsite.repository;

import com.kltn.medicalwebsite.entity.appointmentCancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentCancellationRepository extends JpaRepository<appointmentCancellation,Long> {
}
