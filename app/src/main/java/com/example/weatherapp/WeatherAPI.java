package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("weather")
    Call<WeatherResponse> getWeatherByCity(
            @Query("q") String city, // Название города
            @Query("appid") String apiKey, // Ваш API-ключ
            @Query("units") String units // Единицы измерения (например, метрики)
    );
}
