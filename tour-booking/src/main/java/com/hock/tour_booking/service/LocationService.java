package com.hock.tour_booking.service;

import com.hock.tour_booking.dto.request.LocationRequets;
import com.hock.tour_booking.entity.Location;
import com.hock.tour_booking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location saveLocation(LocationRequets requets) {
        Location location = new Location();
        location.setId(requets.getId());
        location.setName(requets.getName());
        location.setLatitude(requets.getLatitude());
        location.setLongitude(requets.getLongitude());
        location.setDescription(requets.getDescription());
        return locationRepository.save(location);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
