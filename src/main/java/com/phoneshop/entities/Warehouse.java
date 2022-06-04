package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "WAREHOUSE")
@Getter @NoArgsConstructor
public class Warehouse{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse")
    private Set<Depository> depositories;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "warehouse")
    private Set<Lab> labs;

    private String address;

    public Warehouse(String address) {
        this.address = address;
    }

    public Warehouse(Set<Depository> depositories, Set<Lab> labs, String address) {
        this.depositories = depositories;
        this.labs = labs;
        this.address = address;
    }
}