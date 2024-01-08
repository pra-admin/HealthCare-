package com.HealthCare.service;

import com.HealthCare.payload.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    DoctorDto readDoctor(String doctorId);

    List<DoctorDto> readAllDoctors();

    DoctorDto updateDoctor(String doctorId, DoctorDto doctorDto);

    DoctorDto deleteDoctor(String doctorId);
}
