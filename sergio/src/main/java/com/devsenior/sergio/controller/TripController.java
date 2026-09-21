package com.devsenior.sergio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.sergio.dto.TripRequest;
import com.devsenior.sergio.model.Trip;
import com.devsenior.sergio.service.TripService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/trips")
public class TripController {

    private final TripService service;

    public TripController(TripService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody TripRequest request ){
        Trip trip = service.createTrip(request);
        return ResponseEntity.status(201).body(trip);
    }

    @GetMapping 
    public ResponseEntity<List<Trip>> listTrips(){
        List<Trip> trips = service.listTrips();
        return ResponseEntity.ok(trips);
    }
    
}
