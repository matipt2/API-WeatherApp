# Weather Application

The Weather Application is a simple Java GUI application that allows users to check the current weather for a selected city. The application utilizes the API provided by OpenWeatherMap.

## Prerequisites

1. Java Development Kit (JDK) version 8 or above.
2. An API key from OpenWeatherMap. You can generate an API key by registering on the [OpenWeatherMap](https://openweathermap.org/) website.

## Configuration

1. Clone this project to your local repository.
2. In the `WeatherAPI.java` file, you'll find the `apiKey` field. Replace the value `YOUR_API_KEY` with your OpenWeatherMap API key.

## Usage

1. Upon launching the application, enter the name of the city in the text field.
2. Click the "Update" button to fetch the weather data for the specified city.
3. The application will display the current temperature, maximum and minimum temperature, humidity, and wind speed for the provided city.

## Known Issues

- The application may not function correctly if the OpenWeatherMap API does not respond or returns an error or you didn't replace the value 'YOUR_API_KEY' with generated key.

