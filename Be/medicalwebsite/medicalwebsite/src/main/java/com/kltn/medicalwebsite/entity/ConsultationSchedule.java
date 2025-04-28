package com.kltn.medicalwebsite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class ConsultationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @ManyToOne
    @JoinColumn(name = "id_doctor",referencedColumnName = "id")
    @JsonBackReference
    private  Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_medicalservice",referencedColumnName = "id")
    @JsonBackReference(value = "medical-type-services")
    private  MedicalType medicalType;

    private LocalDate dateAppointment;

    private LocalTime startTime;
    private  LocalTime endTime;

    private  Boolean isBooked;

    @OneToMany(mappedBy = "consulationSchedule",cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;

    public ConsultationSchedule() {
    }

    public ConsultationSchedule(Long id, Doctor doctor, MedicalType medicalType, LocalDate dateAppointment, LocalTime startTime, LocalTime endTime, Boolean isBooked) {
        this.id = id;
        this.doctor = doctor;
        this.medicalType = medicalType;
        this.dateAppointment = dateAppointment;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public MedicalType getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(MedicalType medicalType) {
        this.medicalType = medicalType;
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

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
}