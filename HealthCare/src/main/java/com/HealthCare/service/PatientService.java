package com.HealthCare.service;

import com.HealthCare.payload.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto saveUser(PatientDto patientDto);

    List<PatientDto> getAllUser();

    PatientDto getUser(int id);

    void deleteUserById(int id);

    PatientDto updateUser(PatientDto patientDto, int id);
}
