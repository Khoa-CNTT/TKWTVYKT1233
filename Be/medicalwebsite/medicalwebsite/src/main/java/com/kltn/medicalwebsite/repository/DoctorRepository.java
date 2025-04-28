package com.kltn.medicalwebsite.repository;


import com.kltn.medicalwebsite.entity.Doctor;
import com.kltn.medicalwebsite.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor,Long> {


    @Query("SELECT d FROM Doctor d " +
            "WHERE (:name IS NULL OR LOWER(d.client.fullName) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:speciality IS NULL OR d.speciality.id = :speciality)")
    List<Doctor> findAllDoctorByNameAndSpeciality(@Param("name") String name,
                                                  @Param("speciality") Long idSpeciality);
}
