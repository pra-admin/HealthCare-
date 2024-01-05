package com.HealthCare;

import com.HealthCare.entity.Patient;
import com.HealthCare.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void savePatient() {
        Patient patient = new Patient();
        patient.setPName("prajwal");
        patient.setPAge(25);
        patient.setPMobileNumber(Long.parseLong("8793963310"));
        patient.setPEmail("prajwal@gmail.com");
        patient.setPassword("prajwal@123");

        Patient save = patientRepository.save(patient);

        System.out.println(save);
    }

    @Test
    void getPatient(){
        List<Patient> all = patientRepository.findAll();
        System.out.println(all);
    }
}
