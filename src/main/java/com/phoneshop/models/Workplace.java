package com.phoneshop.models;

import javax.persistence.*;
import java.util.Set;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Workplace extends Place {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workplace")
    private Set<User> users;

}
