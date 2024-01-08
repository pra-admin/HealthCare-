package com.HealthCare.entity;

import com.HealthCare.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String specialization;
    private int experience;
    private String clinic;
    private String email;
    private String password;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIME)
    @CreationTimestamp
    private Date createTime;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date updateDate;

    @Temporal(TemporalType.TIME)
    @UpdateTimestamp
    private Date updateTime;

}
