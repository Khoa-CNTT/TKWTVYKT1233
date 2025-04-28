package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.request.AppointmentRequest;
import com.kltn.medicalwebsite.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {


    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<?> reserveAppointment(@RequestParam("ScheduleId") Long scheduleId,
                                                @RequestBody AppointmentRequest appointmentRequest) {
        Appointment appointment =  appointmentService.bookAppointment(scheduleId, appointmentRequest);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

    @GetMapping("/appointment/{id}")
    public  ResponseEntity<Appointment> findAppointmentById(@PathVariable("id") Long id){
         Appointment appointment = appointmentService.findAppointmentById(id);
         return  new ResponseEntity<>(appointment, HttpStatus.OK);
    }
}
