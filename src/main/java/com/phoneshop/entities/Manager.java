package com.phoneshop.entities;

import com.phoneshop.models.User;

import javax.persistence.*;

@Entity
@Table(name = "MANAGERS")
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    public Manager() {

    }

}
