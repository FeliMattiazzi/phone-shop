package com.phoneshop.entities;

import com.phoneshop.models.Place;
import com.phoneshop.models.Supply;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "DEPOSITORIES")
public class Depository extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depositoryId;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depository")
    private Set<Supply> supplies;

}
