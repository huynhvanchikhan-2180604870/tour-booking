package com.hock.tour_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "locations")
public class Location {
    @Id
    private UUID id;

    private String name;
    private String description;
    private String latitude;
    private String longitude;

    @OneToMany(mappedBy = "location")
    private Set<Tour> tours;
}
