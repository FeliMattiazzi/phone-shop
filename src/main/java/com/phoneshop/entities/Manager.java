package com.phoneshop.entities;

import com.phoneshop.models.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MANAGERS")
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    public Manager() {

    }

}
