package com.kltn.medicalwebsite.request;

public class MedicalRecordRequest {

    private  Long clientId;
    private  Long doctorId;
    private  String diagnosis;
    private  String prescription;


    public MedicalRecordRequest() {
    }

    public MedicalRecordRequest(Long clientId, Long doctorId, String diagnosis, String prescription) {
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
