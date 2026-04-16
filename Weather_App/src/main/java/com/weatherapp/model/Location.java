package com.weatherapp.model;

public class Location {
    private String name;
    private String country;
    private double latitude;
    private double longitude;

    public Location(String name, String country, double latitude, double longitude) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return name + ", " + country + " (" + latitude + ", " + longitude + ")";
    }
}
