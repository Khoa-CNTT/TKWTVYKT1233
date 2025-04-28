package com.kltn.medicalwebsite.service;


import com.kltn.medicalwebsite.entity.Client;
import com.kltn.medicalwebsite.entity.Doctor;
import com.kltn.medicalwebsite.entity.MedicalRecord;
import com.kltn.medicalwebsite.exception.ClientException;
import com.kltn.medicalwebsite.exception.DoctorException;
import com.kltn.medicalwebsite.exception.MedicalRecordException;
import com.kltn.medicalwebsite.repository.ClientRepository;
import com.kltn.medicalwebsite.repository.DoctorRepository;
import com.kltn.medicalwebsite.repository.MeidcalRecordRepository;
import com.kltn.medicalwebsite.request.MedicalRecordRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImlp implements MedicalRecordService {



      private MeidcalRecordRepository medicalRecordRepository;

      private DoctorRepository doctorRepository;
      private ClientRepository clientRepository;

    public MedicalRecordServiceImlp(MeidcalRecordRepository medicalRecordRepository, DoctorRepository doctorRepository, ClientRepository clientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.doctorRepository = doctorRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public MedicalRecord addMedicalRecord(MedicalRecordRequest medicalRecord) {
      Doctor doctor = doctorRepository.findById(medicalRecord.getDoctorId()).orElseThrow(() -> new DoctorException("Doctor not found"));
      Client client = clientRepository.findById(medicalRecord.getClientId()).orElseThrow(() -> new ClientException("Client not found"));

      MedicalRecord newMedicalRecord = new MedicalRecord();
      newMedicalRecord.setClient(client);
      newMedicalRecord.setDoctor(doctor);
      newMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
      newMedicalRecord.setPrescription(medicalRecord.getPrescription());
      newMedicalRecord.setCreatedAt(LocalDateTime.now());
        return medicalRecordRepository.save(newMedicalRecord);
    }

    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecordRequest medicalRecordRequest,Long medicalRecordId) {
        MedicalRecord record = findMedicalRecordById(medicalRecordId);
        Client client = clientRepository.findById(medicalRecordRequest.getClientId()).orElseThrow(() -> new ClientException("client not found"));
        Doctor doctor = doctorRepository.findById(medicalRecordRequest.getDoctorId()).orElseThrow(( () -> new DoctorException("doctor not found")));
         record.setCreatedAt(LocalDateTime.now());
         record.setClient(client);
         record.setDoctor(doctor);
         record.setDiagnosis(medicalRecordRequest.getDiagnosis());
         record.setPrescription(medicalRecordRequest.getPrescription());
        return medicalRecordRepository.save(record);
    }

    @Override
    public List<MedicalRecord> findMedicalRecordByDoctor(Long doctorId) {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findMedicalRecordByDoctor(doctorId);
        medicalRecords = medicalRecords.stream().sorted(Comparator.comparing(MedicalRecord::getId).reversed()).collect(Collectors.toList());
        return  medicalRecords;
    }

    @Override
    public List<MedicalRecord> findMedicalRecordByUser(Long userId) {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findMedicalRecordByClient(userId);
        medicalRecords = medicalRecords.stream().sorted(Comparator.comparing(MedicalRecord::getId).reversed()).collect(Collectors.toList());
        return  medicalRecords;
    }

    @Override
    public MedicalRecord findMedicalRecordById(Long medicalRecordId) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElseThrow(() -> new MedicalRecordException("MedicalRecord not found with :"+medicalRecordId));
        return medicalRecord;
    }
}
