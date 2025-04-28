package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.MedicalRecord;
import com.kltn.medicalwebsite.request.MedicalRecordRequest;

import java.util.List;

public interface MedicalRecordService {

    MedicalRecord addMedicalRecord(MedicalRecordRequest medicalRecord);
    MedicalRecord updateMedicalRecord(MedicalRecordRequest medicalRecordRequest,Long medicalRecordId);
    List<MedicalRecord> findMedicalRecordByDoctor(Long doctorId);
    List<MedicalRecord> findMedicalRecordByUser(Long userId);
    MedicalRecord findMedicalRecordById(Long medicalRecordId);
}
