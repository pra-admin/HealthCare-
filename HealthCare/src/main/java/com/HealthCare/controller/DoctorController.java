package com.HealthCare.controller;

import com.HealthCare.payload.DoctorDto;
import com.HealthCare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.createDoctor(doctorDto), HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> readDoctor(@PathVariable String doctorId) {
        return new ResponseEntity<>(doctorService.readDoctor(doctorId), HttpStatus.OK);
    }

    @PutMapping("update/doctor/{doctorId}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable String doctorId, @RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.updateDoctor(doctorId, doctorDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<DoctorDto> deleteDoctor(@PathVariable String doctorId) {
        return new ResponseEntity<>(doctorService.deleteDoctor(doctorId), HttpStatus.OK);
    }
}
