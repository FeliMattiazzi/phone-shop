package com.phoneshop.entities;

import com.phoneshop.models.Supply;
import com.phoneshop.models.Workplace;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEPOSITORIES")
public class Depository extends Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depositoryId;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depository")
    private Set<Supply> supplies;

}
