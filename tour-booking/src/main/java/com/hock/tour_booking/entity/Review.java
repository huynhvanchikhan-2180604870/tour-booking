package com.hock.tour_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private UUID id;

    @ManyToOne
    private Tour tour;

    @ManyToOne
    private User user;

    private int rating;
    private String comment;
    private LocalDateTime review_date;
    private boolean is_approved;
}
