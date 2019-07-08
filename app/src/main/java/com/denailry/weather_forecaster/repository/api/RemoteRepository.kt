package com.denailry.weather_forecaster.repository.api

import android.util.Log
import com.denailry.weather_forecaster.model.Weather as WeatherModel
import com.denailry.weather_forecaster.repository.Repository
import com.denailry.weather_forecaster.repository.api.data.Weather
import com.denailry.weather_forecaster.repository.api.data.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository : Repository {
    override fun getWeathersByCityName(cityName: String, listener: Repository.ResponseListener) {
        val api = OpenWeatherAPI.getInstance()
        val call = api.getByCityName(cityName)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e(javaClass.simpleName, t.message)
            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                val body = response.body()

                if (body != null) {
                    listener.onResponse(parseToWeatherModels(body.list, body.city.name, body.city.country))
                } else {
                    Log.e(javaClass.simpleName, "unexpected null response")
                }
            }
        })
    }

    private fun parseToWeatherModels(weathers: List<Weather>, city: String, countryCode: String) : List<WeatherModel> {
        val result = ArrayList<WeatherModel>()

        for (weather in weathers) {
            result.add(WeatherModel.new(
                weather.weatherDetail[0].description,
                weather.main.temp,
                weather.dt.toLong(),
                city,
                countryCode
            ))
        }

        return result
    }
}