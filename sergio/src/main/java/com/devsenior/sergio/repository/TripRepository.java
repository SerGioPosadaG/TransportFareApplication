package com.devsenior.sergio.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.sergio.model.Trip;

@Repository 
public class TripRepository {

    private final List<Trip> trips = new ArrayList<>();
    private long idCounter = 1L;

    public Trip save(Trip trip){
        trip.setId(idCounter++);
        trips.add(trip);
        return trip;
    }

    public List<Trip> findAll(){
        return trips;
    }

}
