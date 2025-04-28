package com.kltn.medicalwebsite.service;


import com.kltn.medicalwebsite.entity.MedicalType;
import com.kltn.medicalwebsite.exception.MedicalTypeException;
import com.kltn.medicalwebsite.repository.MedicalTypeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalTypeServiceImlp implements  MedicalTypeService{


    private MedicalTypeRepository medicalTypeRepository;

    public MedicalTypeServiceImlp(MedicalTypeRepository medicalTypeRepository) {
        this.medicalTypeRepository = medicalTypeRepository;
    }

    @Override
    public MedicalType create(MedicalType medicalType) {
        medicalType.setCreateAt(LocalDateTime.now());
        return medicalTypeRepository.save(medicalType);
    }

    @Override
    public MedicalType update(MedicalType medicalType, Long id) {
        MedicalType existingMedicalType = medicalTypeRepository.findById(id).orElseThrow(() -> new MedicalTypeException("Medical Type not found with id:"+id));
        existingMedicalType.setNameService(medicalType.getNameService());
        existingMedicalType.setCreateAt(LocalDateTime.now());
        existingMedicalType.setPrice(medicalType.getPrice());
        existingMedicalType.setImagePath(medicalType.getImagePath());
        existingMedicalType.setDescription(medicalType.getDescription());
        return medicalTypeRepository.save(existingMedicalType);
    }

    @Override
    public MedicalType findMedicalTypeById(Long id) {
        MedicalType medicalType = medicalTypeRepository.findById(id).orElseThrow(() -> new MedicalTypeException("Medical type not found with Id :"+id));
        return medicalTypeRepository.save(medicalType);
    }

    @Override
    public List<MedicalType> getAllMedicalType() {
        return medicalTypeRepository.findAll();
    }

    @Override
    public List<MedicalType> findMedicalTypeByNameService(String nameService) {
        List<MedicalType> medicalTypes = medicalTypeRepository.findAll();
        if("tongquat".contains(nameService)){
            medicalTypes =medicalTypes.stream().filter(medicalType -> medicalType.getNameService().contains("Tổng quát")).collect(Collectors.toList());
            return  medicalTypes;
        }
        if("xetnghiem".contains(nameService)){
            medicalTypes =medicalTypes.stream().filter(medicalType -> medicalType.getNameService().contains("Xét nghiệm")).collect(Collectors.toList());
            return  medicalTypes;
        }
        if("phauthuat".contains(nameService)){
            medicalTypes =medicalTypes.stream().filter(medicalType -> medicalType.getNameService().contains("Phẫu Thuật")).collect(Collectors.toList());
            return  medicalTypes;
        }
        if("sieuam".contains(nameService)){
            medicalTypes =medicalTypes.stream().filter(medicalType -> medicalType.getNameService().contains("Siêu âm")).collect(Collectors.toList());
            return  medicalTypes;
        }
        if("ungthu".contains(nameService)){
            medicalTypes =medicalTypes.stream().filter(medicalType -> medicalType.getNameService().contains("Ung thư")).collect(Collectors.toList());
            return  medicalTypes;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        MedicalType existingMedicalType = findMedicalTypeById(id);
        if(existingMedicalType != null){
            medicalTypeRepository.deleteById(id);
        }else {
            throw  new MedicalTypeException("Medical Type not found with id:"+id);
        }
    }
}
