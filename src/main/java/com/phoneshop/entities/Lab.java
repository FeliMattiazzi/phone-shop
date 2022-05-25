package com.phoneshop.entities;

import com.phoneshop.models.Workplace;

import javax.persistence.*;

@Entity
@Table(name = "LABS")
public class Lab extends Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labId;

    public Lab() {
    }

}
