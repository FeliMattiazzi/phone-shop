package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "WAREHOUSE")
@Getter @NoArgsConstructor
public class Warehouse{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse")
    private Set<Depository> depositories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse")
    private Set<Movement> movements;

    private String address;
    private String description;

    public Warehouse(String address, String description) {
        this.address = address;
        this.description = description;
    }

    public Warehouse(Set<Depository> depositories, Set<Movement> movements, String address, String description) {
        this.depositories = depositories;
        this.movements = movements;
        this.address = address;
        this.description = description;
    }
}