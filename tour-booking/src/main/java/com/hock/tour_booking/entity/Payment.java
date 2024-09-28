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
@Table(name = "payments")
public class Payment {
    @Id
    private UUID id;

    @ManyToOne
    private Booking booking;

    private LocalDateTime payment_date;
    private BigDecimal payment_amount;
    private String payment_status;
    private String payment_method;
    private String transaction_id;
}
