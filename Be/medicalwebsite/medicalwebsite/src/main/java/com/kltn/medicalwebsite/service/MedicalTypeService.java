package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.MedicalType;

import java.util.List;

public interface MedicalTypeService {

    MedicalType create(MedicalType medicalType);
    MedicalType update(MedicalType medicalType,Long id);
    MedicalType findMedicalTypeById(Long id);

    List<MedicalType> getAllMedicalType();

    List<MedicalType> findMedicalTypeByNameService(String nameService);


    void delete(Long id);



}
