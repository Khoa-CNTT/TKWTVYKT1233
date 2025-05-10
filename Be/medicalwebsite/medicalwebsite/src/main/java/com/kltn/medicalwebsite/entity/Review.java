package com.kltn.medicalwebsite.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_Client",referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_doctor",referencedColumnName = "id")
    @JsonBackReference
    private Doctor doctor;

    private  Integer rate;

    @Column(columnDefinition = "text")
    private String content;


    private LocalDateTime dateReview;

    public Review() {
    }

    public Review(Long id, Client client, Doctor doctor, Integer rate, String content, LocalDateTime dateReview) {
        this.id = id;
        this.client = client;
        this.doctor = doctor;
        this.rate = rate;
        this.content = content;
        this.dateReview = dateReview;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateReview() {
        return dateReview;
    }

    public void setDateReview(LocalDateTime dateReview) {
        this.dateReview = dateReview;
    }
}
