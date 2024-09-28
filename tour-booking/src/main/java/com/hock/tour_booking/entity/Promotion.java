package com.hock.tour_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    private UUID id;

    private String code;
    private BigDecimal discount;
    private String discount_type;
    private int usage_limit;
    private int current_usage;
    private LocalDate start_date;
    private LocalDate end_date;

    @ManyToOne
    private Tour tour;
}
