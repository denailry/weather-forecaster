package com.denailry.weather_forecaster.repository

import com.denailry.weather_forecaster.model.Weather

interface Repository {
    interface ResponseListener {
        fun onResponse(weathers: List<Weather>)
    }

    fun getWeathersByCityName(cityName: String, listener: ResponseListener)
}