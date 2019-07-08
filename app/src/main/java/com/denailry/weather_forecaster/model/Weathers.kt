package com.denailry.weather_forecaster.model

import com.google.gson.annotations.SerializedName

data class Weathers (
	@SerializedName("dt") val dt : Int,
	@SerializedName("main") val main : Main,
	@SerializedName("weather") val weather : List<Weather>,
	@SerializedName("clouds") val clouds : Clouds,
	@SerializedName("wind") val wind : Wind,
	@SerializedName("sys") val sys : Sys,
	@SerializedName("dt_txt") val dt_txt : String
)