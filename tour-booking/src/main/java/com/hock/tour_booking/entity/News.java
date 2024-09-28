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
@Table(name = "news")
public class News {
    @Id
    private UUID id;

    private String title;
    private String content;
    private String status;
    private String featured_image;

    @ManyToOne
    private User author;

    private LocalDateTime published_date;
}
