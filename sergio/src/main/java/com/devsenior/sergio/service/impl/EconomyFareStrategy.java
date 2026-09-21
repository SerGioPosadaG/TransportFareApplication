package com.devsenior.sergio.service.impl;

import org.springframework.stereotype.Component;

import com.devsenior.sergio.service.FareStrategy;

@Component 
public class EconomyFareStrategy implements FareStrategy {

    @Override 
    public double calculateFare(double distance, double duration){
        return distance * 1.0 + duration * 0.5;
    }

}
