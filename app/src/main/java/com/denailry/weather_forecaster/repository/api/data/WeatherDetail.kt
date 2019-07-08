package com.denailry.weather_forecaster.repository.api.data

import com.google.gson.annotations.SerializedName

data class WeatherDetail (

	@SerializedName("id") val id : Int,
	@SerializedName("main") val main : String,
	@SerializedName("description") val description : String,
	@SerializedName("icon") val icon : String
)