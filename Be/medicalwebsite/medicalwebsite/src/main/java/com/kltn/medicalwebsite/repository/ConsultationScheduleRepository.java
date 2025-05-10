package com.kltn.medicalwebsite.repository;

import com.kltn.medicalwebsite.entity.ConsultationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule,Long>{
    void deleteByDoctorIdAndDateAppointmentBefore(Long doctorId, LocalDate date);
    boolean existsByDoctorIdAndDateAppointment(Long doctorId, LocalDate date);
    void deleteByDoctorId(Long idDoctor);
    List<ConsultationSchedule> findByDoctorIdAndDateAppointmentBefore(Long doctorId,LocalDate today);
}