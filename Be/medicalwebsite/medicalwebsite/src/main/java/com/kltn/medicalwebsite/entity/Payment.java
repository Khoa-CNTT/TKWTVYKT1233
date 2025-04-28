package com.kltn.medicalwebsite.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "id_appointment",referencedColumnName = "id")
    private Appointment appointment;

    private  String status;

    private Double amount;


    private  String vnPayLinkId;
    private  String vnPayLinkReferenceId;
    private  String vnPayLinkStatus;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.REMOVE)
    private List<appointmentCancellation> appointmentCancellations;


    public Payment() {
    }

    public Payment(Long id, Appointment appointment, String status, Double amount, String vnPayLinkId, String vnPayLinkReferenceId, String vnPayLinkStatus) {
        this.id = id;
        this.appointment = appointment;
        this.status = status;
        this.amount = amount;
        this.vnPayLinkId = vnPayLinkId;
        this.vnPayLinkReferenceId = vnPayLinkReferenceId;
        this.vnPayLinkStatus = vnPayLinkStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getVnPayLinkId() {
        return vnPayLinkId;
    }

    public void setVnPayLinkId(String vnPayLinkId) {
        this.vnPayLinkId = vnPayLinkId;
    }

    public String getVnPayLinkReferenceId() {
        return vnPayLinkReferenceId;
    }

    public void setVnPayLinkReferenceId(String vnPayLinkReferenceId) {
        this.vnPayLinkReferenceId = vnPayLinkReferenceId;
    }

    public String getVnPayLinkStatus() {
        return vnPayLinkStatus;
    }

    public void setVnPayLinkStatus(String vnPayLinkStatus) {
        this.vnPayLinkStatus = vnPayLinkStatus;
    }
}
