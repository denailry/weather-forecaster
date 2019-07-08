package com.denailry.weather_forecaster.repository.api.data

import com.google.gson.annotations.SerializedName

data class Sys (

	@SerializedName("pod") val pod : String
)