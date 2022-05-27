package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "LAB")
@Getter @NoArgsConstructor
public class Lab{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lab")
    private Set<Movement> movements;

    private String address;
    private String description;

    public Lab(String address, String description) {
        this.address = address;
        this.description = description;
    }

    public Lab(Set<Movement> movements, String address, String description) {
        this.movements = movements;
        this.address = address;
        this.description = description;
    }
}