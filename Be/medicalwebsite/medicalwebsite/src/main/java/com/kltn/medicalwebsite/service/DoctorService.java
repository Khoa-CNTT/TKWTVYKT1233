package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Doctor;
import com.kltn.medicalwebsite.request.DoctorCreate;
import com.kltn.medicalwebsite.request.DoctorRequest;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAllByNameAndSpeciality(String name, Long idSpeciality);

    Doctor create(DoctorCreate doctor);

    Doctor update(DoctorRequest doctor, Long id);

    String delete(Long id );

    Doctor findDoctorById(Long id);


}
