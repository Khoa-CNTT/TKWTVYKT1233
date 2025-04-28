package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.MedicalType;
import com.kltn.medicalwebsite.service.MedicalTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicaltype")
public class MedicalTypeController {

    private MedicalTypeService medicalTypeService;
    public MedicalTypeController(MedicalTypeService medicalTypeService) {
        this.medicalTypeService = medicalTypeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MedicalType>> getAllMedicalType(){
        List<MedicalType> medicalTypes = medicalTypeService.getAllMedicalType();
        if(medicalTypes.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(medicalTypes,HttpStatus.OK);
        }
    }
    @PostMapping("/create")
    public  ResponseEntity<MedicalType> createMedicalType(@RequestBody MedicalType medicalType){
        MedicalType createMedicalType = medicalTypeService.create(medicalType);
        return  new ResponseEntity<>(createMedicalType,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<MedicalType> updateMedicalType(@RequestBody MedicalType medicalType,@PathVariable("id") Long id){
        MedicalType createMedicalType = medicalTypeService.update(medicalType,id);
        return  new ResponseEntity<>(createMedicalType,HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public  ResponseEntity<MedicalType> findMedicalTypeById(@PathVariable("id")Long id){
        MedicalType medicalType = medicalTypeService.findMedicalTypeById(id);
        return  new ResponseEntity<>(medicalType,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteMedicalType(@PathVariable("id")Long id){
        medicalTypeService.delete(id);
        return  ResponseEntity.ok("Xóa thành công with id :"+id);
    }

    @GetMapping("/search/list")
    public  ResponseEntity<?> findMedicalTypeByNameService (@RequestParam("medicalType") String medicalType){
        List<MedicalType> medicalTypes = medicalTypeService.findMedicalTypeByNameService(medicalType);
        if(medicalTypes.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(medicalTypes,HttpStatus.OK);
        }
    }
}
