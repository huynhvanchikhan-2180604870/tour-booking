package com.hock.tour_booking.dto.request;

import com.hock.tour_booking.entity.TourImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourRequets {
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

    private UUID location_id;
    private UUID category_id;
    private Set<TourImage> images = new HashSet<>();
}
