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

    @Column(columnDefinition = "text")
    private String note;

    private  LocalDateTime birthDatePatient;

    private  String gender;

    private LocalDateTime createdAt;

    public MedicalRecord() {
    }

    public MedicalRecord(Long id, Client client, Doctor doctor, String diagnosis, String prescription, String note, LocalDateTime birthDatePatient, String gender, LocalDateTime createdAt) {
        this.id = id;
        this.client = client;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.note = note;
        this.birthDatePatient = birthDatePatient;
        this.gender = gender;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getBirthDatePatient() {
        return birthDatePatient;
    }

    public void setBirthDatePatient(LocalDateTime birthDatePatient) {
        this.birthDatePatient = birthDatePatient;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
