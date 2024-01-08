package com.HealthCare;

import com.HealthCare.entity.Doctor;
import com.HealthCare.mapper.DoctorMapper;
import com.HealthCare.payload.DoctorDto;
import com.HealthCare.repository.DoctorRepository;
import com.HealthCare.service.impl.DoctorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceImplTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorMapper doctorMapper;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getDoctor() {
        String doctorId = "53995f6d-355a-42d2-b82e-25499f28003c";

        DoctorDto doctorDto = doctorService.readDoctor(doctorId);
        System.out.println(doctorDto);

    }
}
