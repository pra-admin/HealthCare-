package com.HealthCare.service.impl;

import com.HealthCare.entity.Doctor;
import com.HealthCare.exception.ResourceNotFoundException;
import com.HealthCare.mapper.DoctorMapper;
import com.HealthCare.payload.DoctorDto;
import com.HealthCare.repository.DoctorRepository;
import com.HealthCare.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        // TODO : Add some checkpoints for repeated email and mobile numbers.
        doctorDto.setId(UUID.randomUUID().toString());
        return doctorMapper.entityToDto(doctorRepository.save(doctorMapper.dtoToEntity(doctorDto)));
    }

    @Override
    public DoctorDto readDoctor(String doctorId) {
        DoctorDto doctorDto = null;
        try {
            LOGGER.info("Fetching doctor with ID: {}", doctorId);

            doctorDto = doctorMapper.entityToDto(doctorRepository
                    .findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + doctorId)));

        } catch (Exception e) {
            LOGGER.error("An error occurred while fetching doctor with ID: {}", doctorId, e);
        }
        return doctorDto;
    }

    @Override
    public List<DoctorDto> readAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> doctorMapper.entityToDto(doctor))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto updateDoctor(String doctorId, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + doctorId));

        doctor.setName(doctorDto.getName());
        doctor.setAge(doctorDto.getAge());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setClinic(doctorDto.getClinic());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPassword(doctorDto.getPassword());

        return doctorMapper.entityToDto(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDto deleteDoctor(String doctorId) {
        DoctorDto doctorDto = doctorMapper
                .entityToDto(doctorRepository
                        .findById(doctorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + doctorId)));

        doctorRepository.deleteById(doctorId);

        return doctorDto;
    }
}
