package com.denailry.weather_forecaster.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

	@SerializedName("cod") val cod : Int,
	@SerializedName("message") val message : Double,
	@SerializedName("cnt") val cnt : Int,
	@SerializedName("list") val list : List<Weathers>,
	@SerializedName("city") val city : City
)
