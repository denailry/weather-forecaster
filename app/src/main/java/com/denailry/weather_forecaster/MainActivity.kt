package com.denailry.weather_forecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.denailry.weather_forecaster.model.Weather
import com.denailry.weather_forecaster.repository.Repository
import com.denailry.weather_forecaster.repository.api.RemoteRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tvTemperature
import kotlinx.android.synthetic.main.activity_main.tvWeatherType

class MainActivity : AppCompatActivity() {

    private val adapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWeathers.layoutManager = LinearLayoutManager(this)
        rvWeathers.adapter = adapter

        loadWeathers()
    }

    private fun loadWeathers(){
        val repo = RemoteRepository()

        repo.getWeathersByCityName("Jakarta", object : Repository.ResponseListener {
            override fun onResponse(weathers: List<Weather>) {
                val reduced = ArrayList<Weather>()

                for (i in 0 until weathers.size) {
                    if ((i % 8) == 0) {
                        reduced.add(weathers[i])
                    }
                }

                setTodayWeather(reduced[0])
                adapter.update(reduced)
            }
        })
    }

    private fun setTodayWeather(weather: Weather) {
        tvWeatherType.text = weather.type
        tvTemperature.text = weather.tempString()
    }
}
