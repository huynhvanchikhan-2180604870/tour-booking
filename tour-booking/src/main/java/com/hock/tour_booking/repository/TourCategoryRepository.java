package com.hock.tour_booking.repository;

import com.hock.tour_booking.entity.TourCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TourCategoryRepository extends JpaRepository<TourCategory, UUID> {
}
