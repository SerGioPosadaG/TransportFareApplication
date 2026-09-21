package com.devsenior.sergio.model;

public class Trip {
    private long id;
    private double distance;
    private double duration;
    private FareType faretyape;
    private double totalFare;
    private String userEmail;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public FareType getFaretyape() {
        return faretyape;
    }
    public void setFaretyape(FareType faretyape) {
        this.faretyape = faretyape;
    }
    public Double getTotalFare() {
        return totalFare;
    }
    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }


}
