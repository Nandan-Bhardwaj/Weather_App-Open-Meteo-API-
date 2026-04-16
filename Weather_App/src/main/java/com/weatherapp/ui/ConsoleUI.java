package com.weatherapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.weatherapp.model.Weather;
import com.weatherapp.service.WeatherService;
import com.weatherapp.util.Constants;

public class ConsoleUI {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void start() {
        System.out.println("========================================");
        System.out.println(Constants.WELCOME_MESSAGE);
        System.out.println("========================================");

        while (true) {
            try {
                String cityName = getUserInput(Constants.ENTER_CITY_PROMPT);

                if (cityName.equalsIgnoreCase("exit") || cityName.equalsIgnoreCase("quit")) {
                    System.out.println("Thank you for using Weather App. Goodbye!");
                    break;
                }

                if (cityName.trim().isEmpty()) {
                    System.out.println("City name cannot be empty. Please try again.");
                    continue;
                }

                displayWeather(cityName);
            } catch (IOException e) {
                System.err.println(Constants.ERROR_FETCHING_DATA + e.getMessage());
            }

            System.out.println();
        }
    }

    private static String getUserInput(String prompt) throws IOException {
        System.out.print(prompt);
        return reader.readLine();
    }

    private static void displayWeather(String cityName) throws IOException {
        System.out.println("\nFetching weather data for " + cityName + "...");
        
        Weather weather = WeatherService.getWeatherForCity(cityName);
        
        System.out.println("\n========================================");
        System.out.println(weather);
        System.out.println("========================================");
    }
}
