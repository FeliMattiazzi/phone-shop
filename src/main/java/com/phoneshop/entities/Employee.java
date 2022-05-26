package com.phoneshop.entities;

import com.phoneshop.models.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

}
