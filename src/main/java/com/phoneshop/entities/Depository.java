package com.phoneshop.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;


@Entity @Table(name = "DEPOSITORIES")
@Getter
public class Depository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depositoryId;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depository")
    private Set<Supply> supplies;

}
