package com.hock.tour_booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tour_images")
public class TourImage {
    @Id
    private UUID id;


    private String image_url;
    private String alt_text;
    private int display_order;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;
}
