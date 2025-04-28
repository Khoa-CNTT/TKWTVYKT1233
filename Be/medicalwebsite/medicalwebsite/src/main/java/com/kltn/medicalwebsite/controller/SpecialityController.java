package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Speciality;
import com.kltn.medicalwebsite.service.SpecialityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    private SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Speciality>> getAllSpeciality(){
        List<Speciality> specialities = specialityService.findAll();
        if(specialities.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(specialities,HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public  ResponseEntity<Speciality> createSpeciality(@RequestBody Speciality speciality){
        Speciality newSpeciality = specialityService.create(speciality);
        return  new ResponseEntity<>(newSpeciality,HttpStatus.CREATED);}

    @PutMapping("/update/{id}")
    public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality,@PathVariable("id") Long id){
        Speciality updateSpeciality = specialityService.update(speciality,id);
        return  new ResponseEntity<>(updateSpeciality,HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Speciality> findSpecialityById(@PathVariable("id") Long id ){
        Speciality existingSpeciality = specialityService.findSpecialityById(id);
        return  new ResponseEntity<>(existingSpeciality,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteSpecialityById(@PathVariable("id") Long id){
        String deleteSpeciality = specialityService.delete(id);
        return  new ResponseEntity<>(deleteSpeciality,HttpStatus.OK);
    }

}
