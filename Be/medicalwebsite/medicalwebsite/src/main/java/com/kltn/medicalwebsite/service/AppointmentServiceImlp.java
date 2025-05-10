package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.*;
import com.kltn.medicalwebsite.exception.AppointmentException;
import com.kltn.medicalwebsite.exception.ConsultationException;
import com.kltn.medicalwebsite.repository.*;
import com.kltn.medicalwebsite.request.AppointmentRequest;
import com.kltn.medicalwebsite.response.MyAppointmentResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AppointmentServiceImlp implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    private ConsultationScheduleRepository consultationScheduleRepository;

    private PaymentRepository paymentRepository;

    private EmailSenderService emailSenderService;

    private  AppointmentCancellationRepository appointmentCancellationRepository;

    public AppointmentServiceImlp(AppointmentRepository appointmentRepository, ConsultationScheduleRepository consultationScheduleRepository, PaymentRepository paymentRepository, EmailSenderService emailSenderService, AppointmentCancellationRepository appointmentCancellationRepository) {
        this.appointmentRepository = appointmentRepository;
        this.consultationScheduleRepository = consultationScheduleRepository;
        this.paymentRepository = paymentRepository;
        this.emailSenderService = emailSenderService;
        this.appointmentCancellationRepository = appointmentCancellationRepository;
    }

    @Override
    public Appointment bookAppointment(Long ScheduleId, AppointmentRequest appointmentRequest) {
        ConsultationSchedule consultationSchedule = consultationScheduleRepository.findById(ScheduleId).orElseThrow(() -> new ConsultationException("Schedule not found with id :" + ScheduleId));
        if (consultationSchedule.getBooked() == true) {
            throw new ConsultationException("schedule with :" + ScheduleId + " is booked");
        }
        Appointment appointment = mapAppointmentRequestToAppointment(appointmentRequest);
        appointment.setConsulationSchedule(consultationSchedule);
        appointment.setDateAppointment(LocalDateTime.now());
        appointment.setStatus("PENDING");
        consultationSchedule.setBooked(true);
        consultationScheduleRepository.save(consultationSchedule);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new AppointmentException("Appointment not found with id :" + appointmentId));
        return appointment;
    }


    @Override
    public void statusConfirmAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new AppointmentException("Appointment not found with id :" + id));
        ConsultationSchedule schedule = consultationScheduleRepository.findById(appointment.getConsulationSchedule().getId()).orElseThrow(() -> new ConsultationException("schedule not found with id:" + id));
        appointment.setStatus("CONFIRMED");
        schedule.setBooked(true);
        emailSenderService.sendEmail("hophuctam@dtu.edu.vn",
                "Lịch hẹn khám bệnh cho " + appointment.getFullName(),
                "Lịch khám của bạn đã được chấp nhận hãy đến theo khung giờ đã đặt từ " + schedule.getStartTime() + "-" + schedule.getEndTime() + " vào ngày " + schedule.getDateAppointment());
        consultationScheduleRepository.save(schedule);
        appointmentRepository.save(appointment);
    }


    @Override
    @Transactional
    public Boolean statusCancelAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new AppointmentException("Appointment not found with id:" + id));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentTime = appointment.getDateAppointment();
        Optional<Payment> payment = paymentRepository.findFirstByAppointment(appointment);
        appointmentCancellation appointmentCancellation = new appointmentCancellation();
        long minutesDifference = ChronoUnit.MINUTES.between(appointmentTime,now);
        if(minutesDifference <= 45){
            ConsultationSchedule consultationSchedule = consultationScheduleRepository.
                    findById(appointment.getConsulationSchedule().getId()).
                    orElseThrow(() -> new AppointmentException("Schedule not found with id:" + appointment.getConsulationSchedule().getId()));
            appointment.setStatus("CANCELLED");
            consultationSchedule.setBooked(false);
            payment.ifPresent(value -> value.setStatus("CANCELLED"));
            appointmentCancellation.setCreateAt(LocalDateTime.now());
            appointmentCancellation.setMessage("Appointment Cancel");
            appointmentCancellation.setPayment(payment.get());
            appointmentCancellation.setRefund(consultationSchedule.getDoctor().getExaminationPrice() * 0.5);
            consultationScheduleRepository.save(consultationSchedule);
            appointmentRepository.save(appointment);
            paymentRepository.save(payment.get());
            appointmentCancellationRepository.save(appointmentCancellation);
            return  true;
        }else  {
            return  false;
        }

    }

    @Override
    public void deleteAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new AppointmentException("Appointment not found with id :" + id));
        ConsultationSchedule consultationSchedule = consultationScheduleRepository.findById(appointment.getConsulationSchedule().getId()).orElseThrow(() -> new ConsultationException("Schedule not found with id :" + id));
        appointmentRepository.deleteById(appointment.getId());
    }

    @Override
    public void statusCompleteAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new AppointmentException("Appointment not found with id:" + id));
        ConsultationSchedule consultationSchedule = consultationScheduleRepository.
                findById(appointment.getConsulationSchedule().getId()).
                orElseThrow(() -> new AppointmentException("Schedule not found with id:" + appointment.getConsulationSchedule().getId()));
        appointment.setStatus("COMPLETED");
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAllAppointmentForPending(String email) {
        List<Appointment> appointmentsPending = new ArrayList<>();
        if (email != null) {
            List<Appointment> appointments = appointmentRepository.findByEmail(email);
            for (Appointment appointment : appointments) {
                if (appointment.getStatus().equals("PENDING")) {
                    appointmentsPending.add(appointment);
                }
            }
            return appointmentsPending;
        } else {
            throw new AppointmentException("Email not exsits!");
        }
    }

    @Override
    public List<Appointment> findAllAppointmentForConfirm(String email) {
        List<Appointment> appointmentsPending = new ArrayList<>();
        if (email != null) {
            List<Appointment> appointments = appointmentRepository.findByEmail(email);
            for (Appointment appointment : appointments) {
                if (appointment.getStatus().equals("CONFIRMED")) {
                    appointmentsPending.add(appointment);
                }
            }
            return appointmentsPending;
        } else {
            throw new AppointmentException("Email not exsits!");
        }
    }

    @Override
    public List<MyAppointmentResponse> findAllAppointmentByEmail(String email) {
        return appointmentRepository.findByEmail(email).
                stream().
                sorted(Comparator.comparing((Appointment::getId)).reversed()).
                map(appointment -> new MyAppointmentResponse(appointment.getId(),appointment.getConsulationSchedule().getDoctor(), appointment.getConsulationSchedule(),appointment.getStatus())).collect(Collectors.toList());
    }

    @Override
    @Scheduled(fixedRate = 60000)
    @Transactional
    public void deleteUnpaidAppointments() {
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
        List<Appointment> unpaidAppointments = appointmentRepository.findByPaymentsIsEmptyAndDateAppointmentBefore(fiveMinutesAgo);
        for (Appointment appointment : unpaidAppointments){
            Optional<ConsultationSchedule> consultationSchedule = consultationScheduleRepository.findById(appointment.getConsulationSchedule().getId());
             if(consultationSchedule.isPresent()){
                 ConsultationSchedule updateSchedule = consultationSchedule.get();
                 updateSchedule.setBooked(false);
                 consultationScheduleRepository.save(updateSchedule);
             }
             deleteAppointmentById(appointment.getId());
        }
    }


    private Appointment mapAppointmentRequestToAppointment(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        appointment.setAddress(request.getAddress());
        appointment.setFullName(request.getFullName());
        appointment.setGender(request.getGender());
        appointment.setPhone(request.getPhone());
        appointment.setIssueDescription(request.getIssueDescription());
        appointment.setEmail(request.getEmail());
        appointment.setBirthDate(request.getBirthDate());
        return appointment;
    }


}
