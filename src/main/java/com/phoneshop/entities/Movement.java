package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor
public class Movement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @OneToOne
    private Supply supplies;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Lab lab;

    private Integer partsQuantity;

    public Movement(Supply supplies, Integer partsQuantity) {
        this.supplies = supplies;
        this.partsQuantity = partsQuantity;
    }

    public Movement(Supply supplies, Warehouse warehouse, Lab lab, Integer partsQuantity) {
        this.supplies = supplies;
        this.warehouse = warehouse;
        this.lab = lab;
        this.partsQuantity = partsQuantity;
    }

}