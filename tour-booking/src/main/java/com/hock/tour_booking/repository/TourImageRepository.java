package com.hock.tour_booking.repository;

import com.hock.tour_booking.entity.TourImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TourImageRepository extends JpaRepository<TourImage, UUID> {
}
