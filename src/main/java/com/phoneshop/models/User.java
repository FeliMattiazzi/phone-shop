package com.phoneshop.models;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne
    private Workplace workplace;

    private String fullName;

    public User(Workplace workplace, String fullName) {
        this.workplace = workplace;
        this.fullName = fullName;
    }

    public User(){

    }

}
