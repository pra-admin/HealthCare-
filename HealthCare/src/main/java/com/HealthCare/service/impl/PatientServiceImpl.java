package com.HealthCare.service.impl;

import com.HealthCare.entity.Patient;
import com.HealthCare.exception.ResourceNotFound;
import com.HealthCare.payload.PatientDto;
import com.HealthCare.repository.PatientRepository;
import com.HealthCare.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final ModelMapper modelMapper;
    private PatientRepository patientRepository;


    PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper){
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public PatientDto saveUser(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient user = patientRepository.save(patient);
        PatientDto patientDto1 = mapToDto(user);
        return patientDto1;
    }

    @Override
    public List<PatientDto> getAllUser() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtos = patients.stream().
                map(patient -> mapToDto(patient)).collect(Collectors.toList());
       return patientDtos;
    }

    @Override
    public PatientDto getUser(int id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("User not found with this id")
        );

        return mapToDto(patient);
    }

    @Override
    public void deleteUserById(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto updateUser(PatientDto patientDto, int id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("user not found with this id")
        );
        patient.setPName(patientDto.getPName());
        patient.setPAge(patientDto.getPAge());
        patient.setPMobileNumber(patientDto.getPMobileNumber());
        patient.setPEmail(patientDto.getPEmail());
        patient.setPassword(patient.getPassword());

        Patient updatedUser = patientRepository.save(patient);

        return mapToDto(updatedUser);
    }

    public Patient mapToEntity(PatientDto patientdto){
        return modelMapper.map(patientdto, Patient.class);
    }

    public PatientDto mapToDto(Patient patient){
        return modelMapper.map(patient, PatientDto.class);
    }
}
