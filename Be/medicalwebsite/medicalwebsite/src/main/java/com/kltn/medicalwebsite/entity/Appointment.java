package com.kltn.medicalwebsite.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Appointment {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      private  String fullName;
      private  String email;
      private  String phone;
      private  String address;
      private  String gender;
      private  String issueDescription;
      private  String status;
      private LocalDate dateAppointment;
      private  String birthDate;


      @OneToMany(mappedBy = "appointment",cascade = CascadeType.REMOVE)
      private List<Payment> payments;
    @ManyToOne
    @JoinColumn(name = "id_consulationSchedule",referencedColumnName = "id")
    private ConsultationSchedule consulationSchedule;


    public Appointment() {
    }

    public Appointment(Long id, String fullName, String email, String phone, String address, String gender, String issueDescription, String status, String timeSlot, LocalDate dateAppointment, String birthDate, Doctor doctor, MedicalType medicalType, ConsultationSchedule consulationSchedule) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.issueDescription = issueDescription;
        this.status = status;
        this.dateAppointment = dateAppointment;
        this.birthDate = birthDate;

        this.consulationSchedule = consulationSchedule;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(LocalDate dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public ConsultationSchedule getConsulationSchedule() {
        return consulationSchedule;
    }

    public void setConsulationSchedule(ConsultationSchedule consulationSchedule) {
        this.consulationSchedule = consulationSchedule;
    }
}
