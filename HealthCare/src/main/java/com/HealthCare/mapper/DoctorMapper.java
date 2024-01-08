package com.HealthCare.mapper;

import com.HealthCare.entity.Doctor;
import com.HealthCare.payload.DoctorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DoctorDto entityToDto(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDto.class);
    }

    public Doctor dtoToEntity(DoctorDto doctorDto) {
        return modelMapper.map(doctorDto, Doctor.class);
    }
}
