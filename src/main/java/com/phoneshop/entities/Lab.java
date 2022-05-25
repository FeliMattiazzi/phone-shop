package com.phoneshop.entities;

import com.phoneshop.models.User;
import com.phoneshop.models.Workplace;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "LABS")
public class Lab extends Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labId;

    public Lab(String address, String description, Set<User> users) {
        super(address, description, users);
    }

    public Lab(String address, String description) {
        super(address, description);
    }

    public Lab() {
    }

}
