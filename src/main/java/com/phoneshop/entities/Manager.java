package com.phoneshop.entities;

import com.phoneshop.models.User;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "MANAGERS")
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    public Manager() {

    }

}
