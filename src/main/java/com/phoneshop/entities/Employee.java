package com.phoneshop.entities;

import com.phoneshop.models.User;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

}
