package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.ConsultationSchedule;
import com.kltn.medicalwebsite.repository.ConsultationScheduleRepository;
import com.kltn.medicalwebsite.request.UpdateScheduleRequest;
import com.kltn.medicalwebsite.response.TimeSlotResponse;
import com.kltn.medicalwebsite.service.ConsultationScheduleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultationSchedule")
public class ConsultationScheduleController {


    private ConsultationScheduleService consultationScheduleService;

    public ConsultationScheduleController(ConsultationScheduleService consultationScheduleService) {
        this.consultationScheduleService = consultationScheduleService;
    }
    @PostMapping("/create-time-slots/{doctorId}")
    public ResponseEntity<?> createTimeSlots(@PathVariable Long doctorId) {
        consultationScheduleService.createTimeSlot(doctorId);
        return ResponseEntity.ok("Time slots created successfully");
    }

    @DeleteMapping("/delete-slotTimesFor-Doctor/{doctorId}")
    public  ResponseEntity<?> deleteScheduleForDoctor(@PathVariable Long doctorId){
        consultationScheduleService.deleteTimeSlotsForDoctorsId(doctorId);
        return  ResponseEntity.ok("Delete Schedule For Doctor:"+doctorId+"Success");
    }


}
