package com.kltn.medicalwebsite.request;

import java.time.LocalDateTime;

public class DoctorRequest {

    private String imagePath;
    private String description;
    private LocalDateTime datetime;
    private Long speciality;
    private String fullName;
    private String phone;
    private String address;
    private String email;

    public DoctorRequest() {
    }

    public DoctorRequest(String imagePath, String description,  LocalDateTime datetime, Long speciality, String fullName, String phone, String address, String email) {
        this.imagePath = imagePath;
        this.description = description;
        this.datetime = datetime;
        this.speciality = speciality;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Long getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Long speciality) {
        this.speciality = speciality;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
