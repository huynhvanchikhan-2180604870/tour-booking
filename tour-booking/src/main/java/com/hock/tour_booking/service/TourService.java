package com.hock.tour_booking.service;

import com.hock.tour_booking.entity.Tour;
import com.hock.tour_booking.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public TourService(){

    }

    public Tour saveTour(Tour tour){
        return tourRepository.save(tour);
    }

    public Optional<Tour> getTourById(UUID id){
        return tourRepository.findById(id);
    }

    public List<Tour> getAllTour(){
        return tourRepository.findAll();
    }
}
