package com.kltn.medicalwebsite.service;


import com.kltn.medicalwebsite.entity.Speciality;
import com.kltn.medicalwebsite.exception.ClientException;
import com.kltn.medicalwebsite.exception.SpecialityException;
import com.kltn.medicalwebsite.repository.SpecialityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImlp implements SpecialityService {


    private SpecialityRepository specialityRepository;

    public SpecialityServiceImlp(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality create(Speciality speciality) {
        speciality.setCreateAt(LocalDateTime.now());
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality update(Speciality speciality,Long id) {
        Optional<Speciality> existingSpeciality  = specialityRepository.findById(id);
        if(existingSpeciality.isPresent()){
                Speciality updateSpeciality = existingSpeciality.get();
                updateSpeciality.setName(speciality.getName());
                updateSpeciality.setCreateAt(LocalDateTime.now());
                return  specialityRepository.save(updateSpeciality);
        }else {
            throw  new SpecialityException("Speciality not fount with id :"+id);
        }
    }

    @Override
    public String delete(Long id) {
        Optional<Speciality> existing = specialityRepository.findById(id);
        if(existing.isPresent()){
             specialityRepository.deleteById(id);
             return  "Delete Speciality with id :"+id + "success ";
        }else {
            throw  new SpecialityException("Speciality not found with id :"+id);
        }
    }

    @Override
    public Speciality findSpecialityById(Long id) {
        Optional<Speciality> existing = specialityRepository.findById(id);
        if(existing.isPresent()){
             Speciality speciality = existing.get();
             return  speciality;
        }else {
            throw   new SpecialityException("speciality not found with:"+id);
        }

    }
}
