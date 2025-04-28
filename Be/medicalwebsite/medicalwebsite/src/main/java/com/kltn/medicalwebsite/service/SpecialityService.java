package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Speciality;

import java.util.List;

public interface SpecialityService {


    List<Speciality> findAll();

    Speciality create(Speciality speciality);

    Speciality update(Speciality speciality,Long id);

    String delete(Long id);

    Speciality findSpecialityById(Long id);

}
