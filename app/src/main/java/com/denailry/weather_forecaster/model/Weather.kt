package com.denailry.weather_forecaster.model

import java.util.*

data class Weather(
    var type: String,
    var tempInCelcius: Double,
    var date: Date,
    var city: String,
    var countryCode: String) {
    companion object {
        fun new(type: String, tempInKelvin: Double, timestamp: Long, city: String, countryCode: String) : Weather {
            val date = Date(timestamp * 1000)
            val tempInCelcius = tempInKelvin - 273.15
            return Weather(type, tempInCelcius, date, city, countryCode)
        }
    }

    fun tempString() : String {
        return String.format("%.1f", tempInCelcius) + "°C"
    }

    fun dayName() : String? {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)?.toString()
    }
}