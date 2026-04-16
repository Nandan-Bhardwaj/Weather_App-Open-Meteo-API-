package com.weatherapp.model;

public class Weather {
    private Location location;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String weatherDescription;
    private int weatherCode;

    public Weather(Location location, double temperature, int humidity, 
                   double windSpeed, String weatherDescription, int weatherCode) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.weatherDescription = weatherDescription;
        this.weatherCode = weatherCode;
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    @Override
    public String toString() {
        return String.format(
            "Weather at %s:%n" +
            "  Temperature: %.1f°C%n" +
            "  Humidity: %d%%%n" +
            "  Wind Speed: %.1f km/h%n" +
            "  Condition: %s",
            location.getName(),
            temperature,
            humidity,
            windSpeed,
            weatherDescription
        );
    }
}
