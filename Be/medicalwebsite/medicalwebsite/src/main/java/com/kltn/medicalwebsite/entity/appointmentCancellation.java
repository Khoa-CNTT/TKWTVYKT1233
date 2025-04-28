package com.kltn.medicalwebsite.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class appointmentCancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_payment",referencedColumnName = "id")
    private  Payment payment;

    private  String message;

    private LocalDateTime createAt;



    public appointmentCancellation() {
    }

    public appointmentCancellation(Long id, Payment payment, String message, LocalDateTime createAt) {
        this.id = id;
        this.payment = payment;
        this.message = message;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
