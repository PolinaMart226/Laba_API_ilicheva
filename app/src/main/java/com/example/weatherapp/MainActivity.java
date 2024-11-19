package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "da80c137baf3ffc88cd86fc134602b07"; // Наш API-ключ

    private EditText editTextCity;
    private TextView textViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCity = findViewById(R.id.editTextCity);
        textViewTemperature = findViewById(R.id.textViewTemperature);
        Button buttonGetWeather = findViewById(R.id.buttonGetWeather);

        buttonGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = editTextCity.getText().toString();
                if (!city.isEmpty()) {
                    getWeather(city);
                }
            }
        });
    }

    private void getWeather(String city) {
        // Создаем объект Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);

        // Выполнение запроса
        Call<WeatherResponse> call = weatherAPI.getWeatherByCity(city, API_KEY, "metric");
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    float temperature = response.body().getMain().getTemp();
                    textViewTemperature.setText("Температура в " + city + ": " + temperature + " °C");
                } else {
                    textViewTemperature.setText("Город не найден");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                textViewTemperature.setText("Ошибка: " + t.getMessage());
            }
        });
    }
}

