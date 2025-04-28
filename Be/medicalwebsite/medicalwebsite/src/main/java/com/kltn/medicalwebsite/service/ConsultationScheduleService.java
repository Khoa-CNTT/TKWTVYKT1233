package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.ConsultationSchedule;
import com.kltn.medicalwebsite.request.UpdateScheduleRequest;

import java.time.LocalDate;
import java.util.List;

public interface ConsultationScheduleService {

    void createTimeSlot(Long doctorId);

    void updateTimeSlotsForAllDoctors();


    void deleteTimeSlotsForDoctorsId(Long DoctorId);




}