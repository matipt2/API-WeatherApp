package org.example;


public class Main {
    public static void main(String[] args) {
        String apiKey = "API_KEY";
        WeatherAPI weatherAPI = new WeatherAPI(apiKey);
        String city = "Warszawa";
        double temperature = weatherAPI.getTemperature(city);
        double maxTemperature = weatherAPI.getMaxTemperature(city);
        double minTemperature = weatherAPI.getMinTemperature(city);
        double humidity = weatherAPI.getHumidity(city);
        double windSpeed = weatherAPI.getWindSpeed(city);

        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JTextField cityText = new javax.swing.JTextField(city);
            Gui newGui = new Gui(city, temperature, maxTemperature, minTemperature, humidity, windSpeed, weatherAPI, cityText);
            newGui.show();
        });
    }
}