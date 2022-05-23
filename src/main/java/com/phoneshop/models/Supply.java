package com.phoneshop.models;

import com.phoneshop.entities.Depository;

import javax.persistence.*;

@Entity
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    @ManyToOne
    private Depository depository;

    private Long codPart;
    private String description;
    private Boolean usable;
    private Boolean critical;

    public Supply(Long codPart, String description, Depository depository, Boolean usable, Boolean critical) {
        this.codPart = codPart;
        this.description = description;
        this.depository = depository;
        this.usable = usable;
        this.critical = critical;
    }

    public Supply() {
    }
}
