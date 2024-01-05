package com.HealthCare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pId;
    @Column
    String pName;
    @Column
    int pAge;

    @Column(unique=true, nullable = false)
    long pMobileNumber;

    @Column(unique=true, nullable = false)
    String pEmail;

    @Column(unique=true, nullable = false)
    String password;
}
