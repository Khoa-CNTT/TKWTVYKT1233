package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Client;
import com.kltn.medicalwebsite.entity.Doctor;
import com.kltn.medicalwebsite.entity.Speciality;
import com.kltn.medicalwebsite.exception.DoctorException;
import com.kltn.medicalwebsite.repository.ClientRepository;
import com.kltn.medicalwebsite.repository.DoctorRepository;
import com.kltn.medicalwebsite.repository.SpecialityRepository;
import com.kltn.medicalwebsite.request.DoctorCreate;
import com.kltn.medicalwebsite.request.DoctorRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DoctorServiceImlp implements  DoctorService{


    private DoctorRepository doctorRepository;

    private ClientService clientService ;

    private ClientRepository clientRepository;

    private SpecialityRepository specialityRepository;

    public DoctorServiceImlp(DoctorRepository doctorRepository, ClientService clientService, ClientRepository clientRepository, SpecialityRepository specialityRepository) {
        this.doctorRepository = doctorRepository;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public List<Doctor> findAllByNameAndSpeciality(String name, Long idSpeciality) {
        List<Doctor> doctors = doctorRepository.findAllDoctorByNameAndSpeciality(name,idSpeciality);
        doctors = doctors.stream().sorted(Comparator.comparing(Doctor::getId).reversed()).collect(Collectors.toList());
        return  doctors;
    }

    @Override
    public Doctor create(DoctorCreate doctor) {
       Optional<Client> client = clientRepository.findById(doctor.getClient());
       Optional<Speciality> speciality = specialityRepository.findById(doctor.getSpeciality());
       if(client.isPresent() && speciality.isPresent()){
           Doctor newDoctor = new Doctor();
            Client updateClient = client.get();
            updateClient.setRole("ROLE_DOCTOR");
            newDoctor.setClient(client.get());
            newDoctor.setSpeciality(speciality.get());
            newDoctor.setDatetime(LocalDateTime.now());
            newDoctor.setImagePath(doctor.getImagePath());
            newDoctor.setDescription(doctor.getDescription());
            newDoctor.setExaminationPrice(doctor.getPrice());
            clientRepository.save(updateClient);
            return  doctorRepository.save(newDoctor);
       }else {
           throw  new DoctorException("Create Doctor Fail");
       }

    }

    @Override
    public Doctor update(DoctorRequest doctor, Long id) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(id);
        Optional<Speciality> existingSpeciality = specialityRepository.findById(doctor.getSpeciality());
        if(existingDoctor.isPresent()){
              Doctor updateDoctor = existingDoctor.get();
              if(doctor.getImagePath() != null){
                  updateDoctor.setImagePath(doctor.getImagePath());
              }
              if(doctor.getDescription() != null){
                  updateDoctor.setDescription(doctor.getDescription());
              }
              if(doctor.getSpeciality() != null){
                  updateDoctor.setSpeciality(existingSpeciality.get());
              }
              updateDoctor.setDatetime(LocalDateTime.now());

              Client client = updateDoctor.getClient();
              if(client != null){
                  boolean clientUpdate = false;
                  if(doctor.getFullName() != null){
                      client.setFullName(doctor.getFullName());;
                      clientUpdate = true;
                  }
                  if(doctor.getEmail() != null){
                      client.setEmail(doctor.getEmail());;
                      clientUpdate = true;
                  }
                  if(doctor.getPhone() != null){
                      client.setPhone(doctor.getPhone());;
                      clientUpdate = true;
                  }
                  if(doctor.getAddress() != null){
                      client.setAddress(doctor.getAddress());;
                      clientUpdate = true;
                  }

                  if(clientUpdate){
                      clientRepository.save(client);
                  }
              }


              return  doctorRepository.save(updateDoctor);
        }else {
            throw  new DoctorException("Doctor not found with id :"+id);
        }
    }

    @Override
    public String delete(Long id) {
         Optional<Doctor> existingDoctor = doctorRepository.findById(id);
         if(existingDoctor.isPresent()){
             doctorRepository.deleteById(id);
             return   "Delete Doctor with id:"+id +" "+ "success";
         }else {
             throw  new DoctorException("doctor not found with id :"+id);
         }
    }

    @Override
    public Doctor findDoctorById(Long id) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(id);
        if(existingDoctor.isPresent()){
            Doctor doctor = existingDoctor.get();
            return  doctor;
        }else {
            throw  new DoctorException("doctor not found with id :"+id);
        }
    }
}
