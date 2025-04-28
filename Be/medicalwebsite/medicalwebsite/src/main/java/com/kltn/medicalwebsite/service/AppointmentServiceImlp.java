package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.entity.ConsultationSchedule;
import com.kltn.medicalwebsite.entity.Doctor;
import com.kltn.medicalwebsite.entity.MedicalType;
import com.kltn.medicalwebsite.exception.AppointmentException;
import com.kltn.medicalwebsite.exception.ConsultationException;
import com.kltn.medicalwebsite.exception.DoctorException;
import com.kltn.medicalwebsite.repository.AppointmentRepository;
import com.kltn.medicalwebsite.repository.ConsultationScheduleRepository;
import com.kltn.medicalwebsite.repository.DoctorRepository;
import com.kltn.medicalwebsite.repository.MedicalTypeRepository;
import com.kltn.medicalwebsite.request.AppointmentRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class AppointmentServiceImlp implements  AppointmentService{

    private AppointmentRepository appointmentRepository;

    private ConsultationScheduleRepository consultationScheduleRepository;
    public AppointmentServiceImlp(AppointmentRepository appointmentRepository, ConsultationScheduleRepository consultationScheduleRepository) {
        this.appointmentRepository = appointmentRepository;

        this.consultationScheduleRepository = consultationScheduleRepository;
    }
    @Override
    public Appointment bookAppointment(Long ScheduleId, AppointmentRequest appointmentRequest) {
        ConsultationSchedule consultationSchedule = consultationScheduleRepository.findById(ScheduleId).orElseThrow(() -> new ConsultationException("Schedule not found with id :"+ScheduleId));

        Appointment appointment = mapAppointmentRequestToAppointment(appointmentRequest);
        appointment.setConsulationSchedule(consultationSchedule);
        appointment.setDateAppointment(LocalDate.now());
        appointment.setStatus("PENDING");
        consultationSchedule.setBooked(true);
        consultationScheduleRepository.save(consultationSchedule);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new AppointmentException("Appointment not found with id :"+appointmentId));
        return appointment;
    }

    private Appointment mapAppointmentRequestToAppointment( AppointmentRequest request) {
         Appointment appointment = new Appointment();
        appointment.setAddress(request.getAddress());
        appointment.setFullName(request.getFullName());
        appointment.setGender(request.getGender());
        appointment.setPhone(request.getPhone());
        appointment.setIssueDescription(request.getIssueDescription());
        appointment.setEmail(request.getEmail());
        appointment.setBirthDate(request.getBirthDate());
        return  appointment;
    }


}
