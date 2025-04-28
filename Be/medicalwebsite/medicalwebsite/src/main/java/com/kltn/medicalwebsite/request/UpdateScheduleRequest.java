package com.kltn.medicalwebsite.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateScheduleRequest {
    private LocalDate dateAppointment;
    private LocalTime startTime;
    private LocalTime endTime;

    public UpdateScheduleRequest() {
    }

    public UpdateScheduleRequest(LocalDate dateAppointment, LocalTime startTime, LocalTime endTime) {
        this.dateAppointment = dateAppointment;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(LocalDate dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
