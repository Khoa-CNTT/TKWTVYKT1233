package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.request.AppointmentRequest;
import com.kltn.medicalwebsite.response.MyAppointmentResponse;
import com.kltn.medicalwebsite.service.AppointmentService;
import com.kltn.medicalwebsite.service.EmailSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public  ResponseEntity<Appointment> findAppointmentById(@PathVariable("id") Long id){
         Appointment appointment = appointmentService.findAppointmentById(id);
         return  new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @PutMapping("/confirm/{id}")
    public  ResponseEntity<?> updateConfirmAppointment(@PathVariable("id")Long id){
        appointmentService.statusConfirmAppointmentById(id);
        return ResponseEntity.ok("set Confirm success");
    }

    @PutMapping("/cancel/{id}")
    public  ResponseEntity<?> updateCancelAppointment(@PathVariable("id")Long id){
         Boolean checkAppointmentCancel =  appointmentService.statusCancelAppointmentById(id);
         if(checkAppointmentCancel){
             return ResponseEntity.ok("Hủy Thành Công !");
         }else {
             return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }

    }
    @PutMapping("/complete/{id}")
    public  ResponseEntity<?> updateCompleteAppointment(@PathVariable("id")Long id){
        appointmentService.statusCompleteAppointmentById(id);
        return ResponseEntity.ok("set completed success");
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteAppointment(@PathVariable("id") Long id){
        appointmentService.deleteAppointmentById(id);
        return  ResponseEntity.ok("set delete success");
    }

    @GetMapping("/list/pending")
    public  ResponseEntity<List<Appointment>> findAllAppointmentForPending(@RequestParam("email") String email){
        List<Appointment>appointments =  appointmentService.findAllAppointmentForPending(email);
        if(appointments.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(appointments,HttpStatus.OK);
        }
    }

    @GetMapping("/list/confirm")
    public  ResponseEntity<List<Appointment>> findAllAppointmentForConfirm(@RequestParam("email") String email){
        List<Appointment>appointments =  appointmentService.findAllAppointmentForConfirm(email);
        if(appointments.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(appointments,HttpStatus.OK);
        }
    }
    @GetMapping("/list-appointment-by-email")
    public  ResponseEntity<List<MyAppointmentResponse>> findAllAppointmentByEmail(@RequestParam("email")String email){
        List<MyAppointmentResponse> appointments = appointmentService.findAllAppointmentByEmail(email);
        if(appointments.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(appointments,HttpStatus.OK);
        }
    }


}
