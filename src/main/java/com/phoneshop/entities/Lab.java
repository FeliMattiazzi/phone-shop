package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "LAB")
@Getter @NoArgsConstructor
public class Lab{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lab")
    private Set<Movement> movements;

    @ManyToOne
    private Warehouse warehouse;

    private String address;

    public Lab(String address) {
        this.address = address;
    }

    public Lab(Set<Movement> movements, Warehouse warehouse, String address) {
        this.movements = movements;
        this.warehouse = warehouse;
        this.address = address;
    }

}