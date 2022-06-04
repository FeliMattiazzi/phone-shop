package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor
public class Supply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    @ManyToOne
    private Depository depository;

    private String supplyName;
    private Boolean critical;
    private Integer quantity;

    public Supply(String supplyName, Boolean critical, Integer quantity) {
        this.supplyName = supplyName;
        this.critical = critical;
        this.quantity = quantity;
    }

    public Supply(Depository depository, String supplyName, Boolean critical, Integer quantity) {
        this.depository = depository;
        this.supplyName = supplyName;
        this.critical = critical;
        this.quantity = quantity;
    }

    public void setDepository(Depository depository) {
        this.depository = depository;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}