package com.HealthCare.payload;

import com.HealthCare.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private String id;
    private String name;
    private String age;
    private Gender gender;
    private String specialization;
    private int experience;
    private String clinic;
    private String email;
    private String password;
}
