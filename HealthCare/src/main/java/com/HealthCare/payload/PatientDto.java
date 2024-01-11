package com.HealthCare.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    int pId;
    String pName;
    int pAge;
    long pMobileNumber;
    String pEmail;
    String password;
}
