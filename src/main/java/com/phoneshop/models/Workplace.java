package com.phoneshop.models;
import com.phoneshop.entities.User;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Workplace extends Place {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workplace")
    private Set<User> users;

    public Workplace(String address, String description, Set<User> users) {
        super(address, description);
        this.users = users;
    }

    public Workplace(String address, String description) {
        super(address, description);
    }

    public Workplace() {
    }

}
