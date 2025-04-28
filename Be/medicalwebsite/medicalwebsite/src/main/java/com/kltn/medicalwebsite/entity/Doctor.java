package com.kltn.medicalwebsite.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String imagePath;

    @ManyToOne
    @JoinColumn(name = "id_client",referencedColumnName = "id")
    private  Client client;

    @ManyToOne
    @JoinColumn(name = "id_speciality",referencedColumnName = "id")
    private  Speciality speciality;

    private  Double examinationPrice;



    @Column(columnDefinition = "text")
    private  String description;
    private LocalDateTime datetime;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE)
    private  List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE)
    private  List<Review> reviews;

    @JsonManagedReference
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE)
    private List<ConsultationSchedule> consultationSchedules;


    public Doctor() {
    }

    public Doctor(Long id, String imagePath, Client client, Speciality speciality, String description, LocalDateTime datetime, List<MedicalRecord> medicalRecords, List<Review> reviews, Double examinationPrice) {
        this.id = id;
        this.imagePath = imagePath;
        this.client = client;
        this.speciality = speciality;
        this.description = description;
        this.datetime = datetime;
        this.examinationPrice = examinationPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Double getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(Double examinationPrice) {
        this.examinationPrice = examinationPrice;
    }
}
