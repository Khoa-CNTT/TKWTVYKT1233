package com.kltn.medicalwebsite.repository;


import com.kltn.medicalwebsite.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeidcalRecordRepository extends JpaRepository<MedicalRecord,Long> {



    @Query("Select m from MedicalRecord m Where m.doctor.id =:doctorId ")
    public List<MedicalRecord> findMedicalRecordByDoctor(@Param("doctorId")Long id);

    @Query("Select m from MedicalRecord m Where m.client.id =:clientId")
    public  List<MedicalRecord> findMedicalRecordByClient(@Param("clientId")Long id);

}
