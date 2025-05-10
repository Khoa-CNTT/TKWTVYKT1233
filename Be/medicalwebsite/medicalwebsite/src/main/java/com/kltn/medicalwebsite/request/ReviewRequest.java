package com.kltn.medicalwebsite.request;


import jakarta.persistence.Column;

public class ReviewRequest {

    private  Long doctorId;
    private  Long clientId;

    @Column(columnDefinition = "text")
    private  String content;

    private  Integer rate;

    public ReviewRequest() {
    }

    public ReviewRequest(Long doctorId, Long clientId, String content, Integer rate) {
        this.doctorId = doctorId;
        this.clientId = clientId;
        this.content = content;
        this.rate = rate;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
