package com.kltn.medicalwebsite.repository;

import com.kltn.medicalwebsite.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment,Long> {

    List<Appointment> findByEmail(String email);
    List<Appointment> findByPaymentsIsEmptyAndDateAppointmentBefore(LocalDateTime localDateTime);

}
