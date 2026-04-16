package com.weatherapp.util;

public class Constants {
    // API Configuration
    public static final String API_BASE_URL = "https://geocoding-api.open-meteo.com/v1";
    public static final String WEATHER_API_BASE_URL = "https://api.open-meteo.com/v1";
    
    public static final String GEOCODING_ENDPOINT = "/search";
    public static final String FORECAST_ENDPOINT = "/forecast";
    
    // Weather Parameters
    public static final String WEATHER_PARAMS = "temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m";
    
    // HTTP Configuration
    public static final int CONNECTION_TIMEOUT_SECONDS = 10;
    public static final int READ_TIMEOUT_SECONDS = 10;
    
    // UI Messages
    public static final String WELCOME_MESSAGE = "Welcome to Weather App!";
    public static final String ENTER_CITY_PROMPT = "Enter city name: ";
    public static final String ERROR_FETCHING_DATA = "Error fetching weather data: ";
    public static final String ERROR_NO_RESULTS = "No results found for the city: ";
    
    private Constants() {
        // Private constructor to prevent instantiation
    }
}
