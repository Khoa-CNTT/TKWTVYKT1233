package com.kltn.medicalwebsite.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @ManyToOne
    @JoinColumn(name = "id_client",referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_doctor",referencedColumnName = "id")
    private Doctor doctor;


    private  String diagnosis;
    @Column(columnDefinition = "text")
    private  String prescription;

    private LocalDateTime createdAt;

    public MedicalRecord() {
    }

    public MedicalRecord(Long id, Client client, Doctor doctor, String diagnosis, String prescription, LocalDateTime createdAt) {
        this.id = id;
        this.client = client;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
