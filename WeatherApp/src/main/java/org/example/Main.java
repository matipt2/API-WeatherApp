package org.example;

public class Main {
    public static void main(String[] args) {

        String apiKey = "a17574d53ccd93d7464afad74d772378";
        WeatherAPI weatherAPI = new WeatherAPI(apiKey);
        String city = "London";
        double temperature = weatherAPI.getTemperature(city);
        double maxTemperature = weatherAPI.getMaxTemperature(city);
        double minTemperature = weatherAPI.getMinTemperature(city);
        double humidity = weatherAPI.getHumidity(city);
        double windSpeed = weatherAPI.getWindSpeed(city);


    }
}
