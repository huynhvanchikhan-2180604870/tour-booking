package com.hock.tour_booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String destination;
    private LocalDate start_date;
    private LocalDate end_date;
    private BigDecimal price;
    private int available_slots;
    private String image_url;
    private String status;
    private int max_capacity;
    private int current_bookings;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)

    private TourCategory category;

    @OneToMany(mappedBy = "tour")
    private Set<TourImage> images;
}
