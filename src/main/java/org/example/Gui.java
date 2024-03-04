package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private String city;
    private double temperature;
    private double maxTemperature;
    private double minTemperature;
    private double humidity;
    private double windSpeed;
    private WeatherAPI weatherAPI;
    private JTextField cityText;
    private JLabel temperatureLabel;
    private JLabel maxTemperatureLabel;
    private JLabel minTemperatureLabel;
    private JLabel humidityLabel;
    private JLabel windSpeedLabel;

    public Gui(String city, double temperature, double maxTemperature, double minTemperature,
               double humidity, double windSpeed, WeatherAPI weatherAPI, JTextField cityText) {
        this.city = city;
        this.temperature = temperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.weatherAPI = weatherAPI;
        this.cityText = cityText;
        initializeLabels();
    }

    private void initializeLabels() {
        temperatureLabel = new JLabel("Temperature: " + String.format("%.2f", temperature) + " °C");
        maxTemperatureLabel = new JLabel("Max Temperature: " + String.format("%.2f", maxTemperature) + " °C");
        minTemperatureLabel = new JLabel("Min Temperature: " + String.format("%.2f", minTemperature) + " °C");
        humidityLabel = new JLabel("Humidity: " + humidity + "%");
        windSpeedLabel = new JLabel("Wind Speed: " + windSpeed + " m/s");
    }

    public void show() {
        JFrame frame = new JFrame("WeatherApp");
        frame.setSize(400, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon originalImageIcon = new ImageIcon(getClass().getResource("/background.jpeg"));
        Image originalImage = originalImageIcon.getImage();
        int newWidth = 700;
        int newHeight = 400;
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        JLabel background = new JLabel();
        background.setLayout(new BorderLayout());

        JButton updateButton = new JButton("Update");
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setOpaque(false);
        panel.add(cityText);
        panel.add(updateButton);
        panel.add(temperatureLabel);
        panel.add(maxTemperatureLabel);
        panel.add(minTemperatureLabel);
        panel.add(humidityLabel);
        panel.add(windSpeedLabel);

        updateButton.addActionListener(this);

        background.add(panel, BorderLayout.NORTH);

        frame.add(background);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();

            if (sourceButton.getText().equals("Update")) {
                String newCity = cityText.getText();

                double newTemperature = weatherAPI.getTemperature(newCity);
                double newMaxTemperature = weatherAPI.getMaxTemperature(newCity);
                double newMinTemperature = weatherAPI.getMinTemperature(newCity);
                double newHumidity = weatherAPI.getHumidity(newCity);
                double newWindSpeed = weatherAPI.getWindSpeed(newCity);

                temperature = newTemperature;
                maxTemperature = newMaxTemperature;
                minTemperature = newMinTemperature;
                humidity = newHumidity;
                windSpeed = newWindSpeed;

                temperatureLabel.setText("Temperature: " + String.format("%.2f", newTemperature) + " °C");
                maxTemperatureLabel.setText("Max Temperature: " + String.format("%.2f", newMaxTemperature) + " °C");
                minTemperatureLabel.setText("Min Temperature: " + String.format("%.2f", newMinTemperature) + " °C");
                humidityLabel.setText("Humidity: " + newHumidity + "%");
                windSpeedLabel.setText("Wind Speed: " + newWindSpeed + " m/s");

                city = newCity;
            }
        }
    }
}
