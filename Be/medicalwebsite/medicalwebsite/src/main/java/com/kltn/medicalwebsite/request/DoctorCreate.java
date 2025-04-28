package com.kltn.medicalwebsite.request;

public class DoctorCreate {

    private String imagePath;
    private  Long client;
    private  Long speciality;
    private  String description;
    private  Double price;


    public DoctorCreate(String imagePath, Long client, Long speciality, String workDay, String description, Double price) {
        this.imagePath = imagePath;
        this.client = client;
        this.speciality = speciality;
        this.description = description;
        this.price = price;
    }

    public DoctorCreate() {
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Long speciality) {
        this.speciality = speciality;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
