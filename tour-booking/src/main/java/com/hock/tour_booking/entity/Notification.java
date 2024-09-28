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
@Table(name = "notifications")
public class Notification {
    @Id
    private UUID id;

    @ManyToOne
    private User user;

    private String message;
    private LocalDateTime notification_date;
    private boolean is_read;
    private String notification_type;
}
