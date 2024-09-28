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
@Table(name = "tour_categories")
public class TourCategory {
    @Id
    private UUID id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Tour> tours;
}
