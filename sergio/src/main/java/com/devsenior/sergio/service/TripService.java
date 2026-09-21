package com.devsenior.sergio.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.sergio.dto.TripRequest;
import com.devsenior.sergio.model.FareType;
import com.devsenior.sergio.model.Trip;
import com.devsenior.sergio.repository.TripRepository;
import com.devsenior.sergio.service.Factory.TotalFactory;



@Service 
public class TripService {
    private final TripRepository tripRepository;
    private final TotalFactory totalFactory;


    public TripService(TripRepository tripRepository, TotalFactory totalFactory) {
        this.tripRepository = tripRepository;
        this.totalFactory = totalFactory;
    }

    public Trip createTrip(TripRequest tripRequest){
        FareType fareType = FareType.valueOf(tripRequest.getFareType());
        double total = totalFactory.calculateTotal(tripRequest);

        Trip trip = new Trip();
        trip.setDistance(tripRequest.getDistance());
        trip.setDuration(tripRequest.getDuration());  
        trip.setFaretyape(fareType);
        trip.setTotalFare(total);
        trip.setUserEmail(tripRequest.getUserEmail());

        return tripRepository.save(trip);
    }

    public List<Trip> listTrips(){
        return tripRepository.findAll().stream()
                                    .sorted(Comparator.comparing(Trip::getTotalFare).reversed())
                                    .toList();
    }     

}
