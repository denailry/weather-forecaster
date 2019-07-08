package com.denailry.weather_forecaster.util

import java.sql.Timestamp
import java.util.*

class Util {
    companion object {
        fun getDayName(timestamp: Int) : String? {
            val calendar = Calendar.getInstance()
            calendar.time = Date(timestamp.toLong() * 1000)
            return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)?.toString()
        }

        fun toCelciusString(tempInKelvin: Double) : String {
            val temp = tempInKelvin - 273.15
            return String.format("%.2f", temp)  + "°C"
        }
    }
}