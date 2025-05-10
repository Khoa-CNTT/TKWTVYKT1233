package com.kltn.medicalwebsite.request;

public class MedicalRecordRequest {

    private  Long clientId;
    private  Long doctorId;
    private  String diagnosis;
    private  String prescription;
    private  String note;
    private  String birthDatePatient;
    private  String gender;


    public MedicalRecordRequest() {

    }

    public MedicalRecordRequest(Long clientId, Long doctorId, String diagnosis, String prescription, String note, String birthDatePatient, String gender) {
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.note = note;
        this.birthDatePatient = birthDatePatient;
        this.gender = gender;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBirthDatePatient() {
        return birthDatePatient;
    }

    public void setBirthDatePatient(String birthDatePatient) {
        this.birthDatePatient = birthDatePatient;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
