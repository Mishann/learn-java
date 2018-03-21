package com.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
    @JsonProperty("weather")
    private WeatherConfig weatherConfig;

    public WeatherConfig getWeatherConfig() {
        return weatherConfig;
    }

    public void setWeatherConfig(WeatherConfig weatherConfig) {
        this.weatherConfig = weatherConfig;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherConfig=" + weatherConfig +
                '}';
    }
}
