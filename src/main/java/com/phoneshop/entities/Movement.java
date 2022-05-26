package com.phoneshop.entities;

import com.phoneshop.models.Supply;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "MOVEMENTS")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @OneToMany
    private Set<Supply> supplies;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Lab lab;

    @ManyToOne
    private Depository depository;

    private Integer partsQuantity;

}
