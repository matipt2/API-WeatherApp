package org.example;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI {
    private String apiKey;

    public WeatherAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    private JSONObject getWeatherData(String city) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return new JSONObject(response.toString());
    }

    public double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public double getTemperature(String city) {
        try {
            JSONObject jsonObject = getWeatherData(city);
            return convertKelvinToCelsius(jsonObject.getJSONObject("main").getDouble("temp"));
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public double getMaxTemperature(String city) {
        try {
            JSONObject jsonObject = getWeatherData(city);
            return convertKelvinToCelsius(jsonObject.getJSONObject("main").getDouble("temp_max"));
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public double getMinTemperature(String city) {
        try {
            JSONObject jsonObject = getWeatherData(city);
            return convertKelvinToCelsius(jsonObject.getJSONObject("main").getDouble("temp_min"));
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public double getHumidity(String city) {
        try {
            JSONObject jsonObject = getWeatherData(city);
            return jsonObject.getJSONObject("main").getDouble("humidity");
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public double getWindSpeed(String city) {
        try {
            JSONObject jsonObject = getWeatherData(city);
            return jsonObject.getJSONObject("wind").getDouble("speed");
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
