package com.weatherapp.service;

import java.io.IOException;

import com.weatherapp.api.OpenMeteoClient;
import com.weatherapp.model.Location;
import com.weatherapp.model.Weather;
import com.weatherapp.util.Constants;

public class WeatherService {
    /**
     * Retrieves weather information for a given city name
     */
    public static Weather getWeatherForCity(String cityName) throws IOException {
        // Step 1: Search for the location
        Location location = OpenMeteoClient.searchLocation(cityName);
        
        if (location == null) {
            throw new IOException(Constants.ERROR_NO_RESULTS + cityName);
        }

        // Step 2: Fetch weather data for the location
        return OpenMeteoClient.fetchWeather(location);
    }
}
