package com.denailry.weather_forecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.denailry.weather_forecaster.repository.api.Api
import com.denailry.weather_forecaster.repository.api.data.WeatherResponse
import com.denailry.weather_forecaster.repository.api.data.Weathers
import com.denailry.weather_forecaster.util.Util
import retrofit2.Callback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tvTemperature
import kotlinx.android.synthetic.main.activity_main.tvWeatherType
import retrofit2.Call
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val adapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWeathers.layoutManager = LinearLayoutManager(this)
        rvWeathers.adapter = adapter

        fetchWeather()
    }

    private fun fetchWeather(){
        val api = Api.getInstance()
        val result = api.getByCityName("Jakarta")
        result.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e(javaClass.simpleName, "Error: ${t.message}")
            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                val result = response.body()
                if (result != null) {
                    val reduced = ArrayList<Weathers>()
                    for (i in 0 until result.list.size) {
                        if ((i % 8) == 0) {
                            reduced.add(result.list[i])
                        }
                    }
                    setTodayWeather(reduced[0])
                    adapter.update(reduced)
                }
            }
        })
    }

    private fun setTodayWeather(weather: Weathers) {
        tvWeatherType.text = weather.weather[0].main
        tvTemperature.text = Util.toCelciusString(weather.main.temp)
    }
}
