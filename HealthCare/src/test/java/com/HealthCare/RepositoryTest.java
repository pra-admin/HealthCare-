package com.HealthCare;

import com.HealthCare.entity.Doctor;
import com.HealthCare.enums.Gender;
import com.HealthCare.exception.ResourceNotFoundException;
import com.HealthCare.mapper.DoctorMapper;
import com.HealthCare.payload.DoctorDto;
import com.HealthCare.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Test
    void saveDoctor() {
        Doctor doctor1 = new Doctor();
        doctor1.setId(UUID.randomUUID().toString());
        doctor1.setName("Dr. John Doe");
        doctor1.setAge("35");
        doctor1.setGender(Gender.MALE);
        doctor1.setSpecialization("Cardiology");
        doctor1.setExperience(10);
        doctor1.setClinic("City Hospital");
        doctor1.setEmail("john.doe@example.com");
        doctor1.setPassword("securePassword");

        Doctor save = doctorRepository.save(doctor1);
        System.out.println(save);
    }

    @Test
    void getDoctor() {
        String doctorId = "53995f6d-355a-42d2-b82e-25499f28003c";
        DoctorDto doctorDto = doctorMapper.entityToDto(
                doctorRepository.findById(doctorId)
                        .orElseThrow(() -> new ResourceNotFoundException("doctor not found with id " + doctorId))
        );
        System.out.println(doctorDto);
    }

    @Test
    void getAllDoctors() {
        List<DoctorDto> doctorsList = doctorRepository.findAll().stream()
                .map(d -> doctorMapper.entityToDto(d)).collect(Collectors.toList());

        for (DoctorDto d : doctorsList) {
            System.out.println(d);
        }
    }

    @Test
    void updateDoctor() {
        String doctorId = "65c41d18-826b-45e0-8607-871ad458d7bf";
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find doctor " + doctorId));
        doctor.setSpecialization("Neurology");
        doctorRepository.save(doctor);
    }

    @Test
    void deleteDoctor() {
        String doctorId = "D123";
        doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find doctor with id " + doctorId));
        doctorRepository.deleteById(doctorId);
    }
}
