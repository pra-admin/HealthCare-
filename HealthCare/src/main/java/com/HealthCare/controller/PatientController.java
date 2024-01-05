package com.HealthCare.controller;

import com.HealthCare.entity.Patient;
import com.HealthCare.payload.PatientDto;
import com.HealthCare.repository.PatientRepository;
import com.HealthCare.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){

        this.patientService = patientService;
    }

    @PostMapping("/save")
    public ResponseEntity<PatientDto> saveUser(@RequestBody PatientDto patientDto){
        PatientDto patient = patientService.saveUser(patientDto);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PatientDto> getUser(){
        List<PatientDto> allUser = patientService.getAllUser();
        return allUser;

    }

    @GetMapping("/delete/{id}")
    public PatientDto getUserById(@PathVariable("id") int id){
        return patientService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        patientService.deleteUserById(id);
        return "user deleted successfully";

    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updateUser(@RequestBody PatientDto patientDto, @PathVariable("id") int id){
        PatientDto patientDto1 = patientService.updateUser(patientDto, id);
        return new ResponseEntity<>(patientDto1, HttpStatus.OK);
    }

}
