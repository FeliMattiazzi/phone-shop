package com.phoneshop.models;

import com.phoneshop.entities.Depository;

import javax.persistence.*;

@Entity
@Table(name = "SUPPLIES")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    @ManyToOne
    private Depository depository;

    private String description;
    private Boolean usable;
    private Boolean critical;

    public Supply(String description, Depository depository, Boolean usable, Boolean critical) {
        this.description = description;
        this.depository = depository;
        this.usable = usable;
        this.critical = critical;
    }

    public Supply() {
    }
}
