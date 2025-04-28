package com.kltn.medicalwebsite.repository;

import com.kltn.medicalwebsite.entity.MedicalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalTypeRepository  extends JpaRepository<MedicalType,Long> {

}
