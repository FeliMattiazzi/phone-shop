package com.phoneshop.entities;

import com.phoneshop.models.Workplace;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WAREHOUSES")
public class Warehouse extends Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Depository> depositories;

    @OneToMany
    private Set<Movement> movements;

}
