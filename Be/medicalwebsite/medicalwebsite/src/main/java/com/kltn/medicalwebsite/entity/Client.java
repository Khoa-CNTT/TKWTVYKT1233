package com.kltn.medicalwebsite.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long  id;

    @Column(columnDefinition = "varchar(50)")
    private  String fullName;

    @Column(columnDefinition = "varchar(50)")
    private  String email;

    @Column(columnDefinition = "varchar(50)")
    private  String phone;


    private  String address;

    @Column(columnDefinition = "varchar(20)")
    private String password;

    @Column(columnDefinition = "varchar(50)")
    private  String role;

    private  Boolean isClock;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<SupportQueue> supportQueues;
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<Statistic> statistics;
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<Review> reviews;
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<Doctor> doctors;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getClock() {
        return isClock;
    }

    public void setClock(Boolean clock) {
        isClock = clock;
    }

    public Client(Long id, String fullName, String email, String phone, String address, String password, String role, Boolean isClock, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.role = role;
        this.isClock = isClock;
        this.createdAt = createdAt;
    }
    public  Client(){}
}
