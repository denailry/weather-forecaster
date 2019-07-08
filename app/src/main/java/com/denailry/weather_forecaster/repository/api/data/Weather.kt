package com.denailry.weather_forecaster.repository.api.data

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("dt") val dt : Int,
    @SerializedName("main") val main : Main,
    @SerializedName("weatherDetail") val weatherDetail : List<WeatherDetail>,
    @SerializedName("clouds") val clouds : Clouds,
    @SerializedName("wind") val wind : Wind,
    @SerializedName("sys") val sys : Sys,
    @SerializedName("dt_txt") val dt_txt : String
)