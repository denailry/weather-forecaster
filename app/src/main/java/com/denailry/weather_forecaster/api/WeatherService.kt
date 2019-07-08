package com.denailry.weather_forecaster.api

import com.denailry.weather_forecaster.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast?appid=${Api.API_KEY}")
    fun getByCityName(@Query("q") city: String): Call<WeatherResponse>
}