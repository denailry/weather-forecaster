package com.denailry.weather_forecaster.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OpenWeatherAPI {
    companion object {
        const val API_KEY = "c53406e99d16ae16a3d0f5f9e39b9ac1"

        private const val API_URL = "http://api.openweathermap.org/data/2.5/"

        private var retrofit: Retrofit? = null

        fun getInstance(): WeatherService {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(API_URL)
                    .build()
            }

            return retrofit!!.create(WeatherService::class.java)
        }
    }
}