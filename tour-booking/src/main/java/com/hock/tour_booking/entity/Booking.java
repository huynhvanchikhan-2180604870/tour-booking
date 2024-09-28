package com.hock.tour_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    private UUID id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tour tour;

    private LocalDateTime booking_date;
    private String status;
    private int number_of_people;
    private BigDecimal total_amount;
    private String payment_method;
    private String special_requests;
}
