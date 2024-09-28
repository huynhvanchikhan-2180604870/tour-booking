package com.hock.tour_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "guides")
public class Guide {
    @Id
    private UUID id;

    private String name;
    private String phone;
    private String email;
    private String languages;

    @ManyToOne
    private Tour tour;
}
