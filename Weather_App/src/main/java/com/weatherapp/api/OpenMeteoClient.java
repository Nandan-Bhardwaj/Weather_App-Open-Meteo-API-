package com.weatherapp.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.weatherapp.model.Location;
import com.weatherapp.model.Weather;
import com.weatherapp.util.Constants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenMeteoClient {
    private static final OkHttpClient client = new OkHttpClient.Builder()
        .connectTimeout(Constants.CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(Constants.READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .build();

    /**
     * Searches for a city by name and returns the first matching location
     */
    public static Location searchLocation(String cityName) throws IOException {
        String url = Constants.API_BASE_URL + Constants.GEOCODING_ENDPOINT 
            + "?name=" + cityName.replace(" ", "%20") + "&count=1&language=en";

        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("API request failed with code: " + response.code());
            }

            String responseBody = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");

            if (results == null || results.size() == 0) {
                return null;
            }

            JsonObject firstResult = results.get(0).getAsJsonObject();
            String name = firstResult.get("name").getAsString();
            String country = firstResult.has("country") ? firstResult.get("country").getAsString() : "Unknown";
            double latitude = firstResult.get("latitude").getAsDouble();
            double longitude = firstResult.get("longitude").getAsDouble();

            return new Location(name, country, latitude, longitude);
        }
    }

    /**
     * Fetches weather data for a given location
     */
    public static Weather fetchWeather(Location location) throws IOException {
        String url = Constants.WEATHER_API_BASE_URL + Constants.FORECAST_ENDPOINT
            + "?latitude=" + location.getLatitude()
            + "&longitude=" + location.getLongitude()
            + "&current=" + Constants.WEATHER_PARAMS;

        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Weather API request failed with code: " + response.code());
            }

            String responseBody = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonObject current = jsonObject.getAsJsonObject("current");

            double temperature = current.get("temperature_2m").getAsDouble();
            int humidity = current.get("relative_humidity_2m").getAsInt();
            double windSpeed = current.get("wind_speed_10m").getAsDouble();
            int weatherCode = current.get("weather_code").getAsInt();
            String weatherDescription = getWeatherDescription(weatherCode);

            return new Weather(location, temperature, humidity, windSpeed, weatherDescription, weatherCode);
        }
    }

    /**
     * Maps WMO weather codes to descriptive strings
     */
    private static String getWeatherDescription(int code) {
        return switch (code) {
            case 0 -> "Clear sky";
            case 1, 2 -> "Mainly clear";
            case 3 -> "Overcast";
            case 45, 48 -> "Foggy";
            case 51, 53, 55 -> "Drizzle";
            case 61, 63, 65 -> "Rain";
            case 71, 73, 75 -> "Snow";
            case 77 -> "Snow grains";
            case 80, 81, 82 -> "Rain showers";
            case 85, 86 -> "Snow showers";
            case 95, 96, 99 -> "Thunderstorm";
            default -> "Unknown";
        };
    }
}
