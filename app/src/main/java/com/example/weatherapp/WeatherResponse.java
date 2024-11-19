package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    private Main main;

    public Main getMain() {
        return main;
    }

    public static class Main {
        private float temp;

        public float getTemp() {
            return temp;
        }
    }
}
