package com.kltn.medicalwebsite.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class chatbot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(columnDefinition = "text")
    private String message;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "iduser",referencedColumnName = "id")
    private Client client;

    public chatbot() {
    }

    public chatbot(Long id, String message, LocalDateTime dateTime, Client client) {
        this.id = id;
        this.message = message;
        this.dateTime = dateTime;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
