package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.MedicalRecord;
import com.kltn.medicalwebsite.request.MedicalRecordRequest;
import com.kltn.medicalwebsite.service.MedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {



    private MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMedicalRecord(@RequestBody MedicalRecordRequest medicalRecordRequest){
         MedicalRecord medicalRecord = medicalRecordService.addMedicalRecord(medicalRecordRequest);
         return  new ResponseEntity<>(medicalRecord, HttpStatus.CREATED);
    }

    @GetMapping("/search/{recordId}")
    public  ResponseEntity<?> findMedicalRecordById (@PathVariable("recordId") Long id){
        MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordById(id);

        return  new ResponseEntity<>(medicalRecord,HttpStatus.OK);
    }

    @PutMapping("/update/{recordId}")
    public  ResponseEntity<?> updateMedicalRecord(@RequestBody MedicalRecordRequest medicalRecordRequest,@PathVariable("recordId") Long id){
        MedicalRecord medicalRecord = medicalRecordService.updateMedicalRecord(medicalRecordRequest,id);
        return  new ResponseEntity<>(medicalRecord,HttpStatus.OK);
    }

    @GetMapping("/listRecordByClient")
    public  ResponseEntity<?> getAllRecordByClient(@RequestParam("clientId")Long id){
        List<MedicalRecord> records = medicalRecordService.findMedicalRecordByUser(id);
        if(records.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(records,HttpStatus.OK);
        }
    }
    @GetMapping("/listRecordByDoctor")
    public  ResponseEntity<?> getAllRecordByDoctor(@RequestParam("doctorId")Long id){
        List<MedicalRecord> records = medicalRecordService.findMedicalRecordByDoctor(id);
        if(records.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(records,HttpStatus.OK);
        }
    }




}
