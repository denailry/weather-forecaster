package com.denailry.weather_forecaster.repository.api.data

import com.google.gson.annotations.SerializedName

data class Coord (

	@SerializedName("lat") val lat : Double,
	@SerializedName("lon") val lon : Double
)