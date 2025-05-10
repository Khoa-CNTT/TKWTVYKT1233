package com.kltn.medicalwebsite.response;

import com.kltn.medicalwebsite.entity.ConsultationSchedule;
import com.kltn.medicalwebsite.entity.Doctor;

public class MyAppointmentResponse {
    private  Long appointment ;
    private Doctor doctor;
    private ConsultationSchedule consultationSchedule;
    private  String status;

    public MyAppointmentResponse() {
    }

    public MyAppointmentResponse(Long appointment, Doctor doctor, ConsultationSchedule consultationSchedule, String status) {
        this.appointment = appointment;
        this.doctor = doctor;
        this.consultationSchedule = consultationSchedule;
        this.status = status;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public ConsultationSchedule getConsultationSchedule() {
        return consultationSchedule;
    }

    public void setConsultationSchedule(ConsultationSchedule consultationSchedule) {
        this.consultationSchedule = consultationSchedule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAppointment() {
        return appointment;
    }

    public void setAppointment(Long appointment) {
        this.appointment = appointment;
    }
}
