package com.phoneshop.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;

    private String address;
    private String description;

    public Place(String address, String description) {
        this.address = address;
        this.description = description;
    }

    public Place() {
    }
}
