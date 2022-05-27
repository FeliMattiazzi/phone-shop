package com.phoneshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @NoArgsConstructor
public class Depository {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depositoryId;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depository")
    private Set<Supply> supplies;

    public Depository(Warehouse warehouse, Set<Supply> supplies) {
        this.warehouse = warehouse;
        this.supplies = supplies;
    }

}