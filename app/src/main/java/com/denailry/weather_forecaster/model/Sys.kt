package com.denailry.weather_forecaster.model

import com.google.gson.annotations.SerializedName

data class Sys (

	@SerializedName("pod") val pod : String
)