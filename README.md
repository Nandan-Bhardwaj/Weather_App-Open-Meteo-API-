# Weather App

A simple CLI-based weather application that fetches real-time weather data using the Open-Meteo API.

## Features

- Search for any city in the world
- Display current weather conditions (temperature, humidity, wind speed)
- Easy-to-use command-line interface
- No API key required (Open-Meteo is free and public)

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Project Structure

```
weather-app/
├── pom.xml                          # Maven configuration
├── README.md                        # Project documentation
├── src/
│   ├── main/
│   │   ├── java/com/weatherapp/
│   │   │   ├── WeatherApp.java          # Entry point
│   │   │   ├── api/OpenMeteoClient.java # API integration
│   │   │   ├── model/                   # Data models
│   │   │   ├── service/                 # Business logic
│   │   │   ├── ui/ConsoleUI.java        # User interface
│   │   │   └── util/Constants.java      # Configuration constants
│   │   └── resources/config.properties  # Configuration
│   └── test/                            # Unit tests (future)
└── target/                              # Build output
```

## Getting Started

### 1. Build the Project

```bash
mvn clean install
```

### 2. Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.weatherapp.WeatherApp"
```

Or, run the JAR directly (after building):

```bash
java -jar target/weather-app-uber.jar
```

## Usage

1. Run the application
2. Enter a city name when prompted (e.g., "London", "Tokyo", "New York")
3. View the current weather data
4. Type "exit" or "quit" to quit the application

### Example Session

```
========================================
Welcome to Weather App!
========================================
Enter city name: London

Fetching weather data for London...

========================================
Weather at London, United Kingdom (51.5085, -0.1257):
  Temperature: 15.3°C
  Humidity: 72%
  Wind Speed: 12.5 km/h
  Condition: Overcast
========================================

Enter city name: quit
Thank you for using Weather App. Goodbye!
```

## Dependencies

- **OkHttp 4.11.0**: For HTTP requests
- **Gson 2.10.1**: For JSON parsing

## API Information

This application uses the **Open-Meteo API**, which is:
- ✅ Free (no API key required)
- ✅ Open-source
- ✅ Covers worldwide weather data

For more information, visit: https://open-meteo.com/

## Future Enhancements

- Add GUI using JavaFX or Swing
- Add unit tests (JUnit 4/5)
- Implement weather forecasting (multi-day)
- Cache recent searches
- Add configuration file support
- Support for multiple languages

## License

MIT License (or your chosen license)

## Author

Your Name
