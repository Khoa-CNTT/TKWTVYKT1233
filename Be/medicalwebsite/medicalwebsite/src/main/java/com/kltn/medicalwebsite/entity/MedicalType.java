package com.kltn.medicalwebsite.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class MedicalType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String imagePath;

    @Column(columnDefinition = "varchar(120)")
    private  String nameService;

    private LocalDateTime createAt;

    private  Double price;

    private  String description;

    @OneToMany(mappedBy = "medicalType",cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "medical-type-services")
    private List<ConsultationSchedule> consultationSchedules;



    public MedicalType() {
    }

    public MedicalType(Long id, String imagePath, String nameService, LocalDateTime createAt, Double price, String description) {
        this.id = id;
        this.imagePath = imagePath;
        this.nameService = nameService;
        this.createAt = createAt;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }


    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
