package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        ImageIcon originalImageIcon = new ImageIcon(getClass().getResource("/background.jpeg"));
        Image originalImage = originalImageIcon.getImage();
        int newWidth = 700;
        int newHeight = 400;
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(new GridBagLayout());


        JLabel cityLabel = new JLabel("City: " + city);
        JLabel temperatureLabel = new JLabel("Temperature: " + temperature + " °C");
        JLabel maxTemperatureLabel = new JLabel("Max Temperature: " + maxTemperature + " °C");
        JLabel minTemperatureLabel = new JLabel("Min Temperature: " + minTemperature + " °C");
        JLabel humidityLabel = new JLabel("Humidity: " + humidity + "%");
        JLabel windSpeedLabel = new JLabel("Wind Speed: " + windSpeed + " m/s");


        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setOpaque(false);
        panel.add(cityLabel);
        panel.add(temperatureLabel);
        panel.add(maxTemperatureLabel);
        panel.add(minTemperatureLabel);
        panel.add(humidityLabel);
        panel.add(windSpeedLabel);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        background.add(panel, gbc);

        
        JPanel headPanel = new JPanel(new BorderLayout());
        headPanel.add(background);


        frame.add(headPanel);

        frame.setVisible(true);
    }
}