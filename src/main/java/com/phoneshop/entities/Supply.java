package com.phoneshop.entities;

import com.phoneshop.enums.SupplyType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor
public class Supply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    @Enumerated(value = EnumType.STRING)
    private SupplyType supplyType;

    @ManyToOne
    private Depository depository;

    private String description;
    private Boolean critical;


    public Supply(SupplyType supplyType, String description, Boolean critical) {
        this.supplyType = supplyType;
        this.description = description;
        this.critical = critical;
    }

    public Supply(SupplyType supplyType, Depository depository, String description, Boolean critical) {
        this.supplyType = supplyType;
        this.depository = depository;
        this.description = description;
        this.critical = critical;
    }

}