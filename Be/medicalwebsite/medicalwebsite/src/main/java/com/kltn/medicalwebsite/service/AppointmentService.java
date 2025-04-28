package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.request.AppointmentRequest;

public interface AppointmentService {

    Appointment bookAppointment(Long ShceduleId, AppointmentRequest appointmentRequest);

    Appointment findAppointmentById(Long appointmentId);
}
