package com.phoneshop.entities;

import com.phoneshop.models.Supply;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "MOVEMENTS")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
