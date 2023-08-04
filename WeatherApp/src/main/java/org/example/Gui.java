package org.example;


import javax.swing.*;

public class Gui {
    private String city;
    private double temperature;
    private double maxTemperature;
    private double minTemperature;
    private double humidity;
    private double windSpeed;

    public Gui(String city, double temperature, double maxTemperature, double minTemperature, double humidity, double windSpeed) {
        this.city = city;
        this.temperature = temperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }
public void show() {
        JFrame frame = new JFrame("WeatherApp");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel cityLabel = new JLabel("City: " + city);
        JLabel temperatureLabel = new JLabel("Temperature: " + temperature + " °C");
        JLabel maxTemperatureLabel = new JLabel("Max Temperature: " + maxTemperature + " °C");
        JLabel minTemperatureLabel = new JLabel("Min Temperature: " + minTemperature + " °C");
        JLabel humidityLabel = new JLabel("Humidity: " + humidity + "%");
        JLabel windSpeedLabel = new JLabel("Wind Speed: " + windSpeed + " m/s");

        JPanel panel = new JPanel();
        panel.add(cityLabel);
        panel.add(temperatureLabel);
        panel.add(maxTemperatureLabel);
        panel.add(minTemperatureLabel);
        panel.add(humidityLabel);
        panel.add(windSpeedLabel);

        frame.add(panel);
        frame.setVisible(true);
        }
        }