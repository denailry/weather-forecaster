package com.denailry.weather_forecaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.denailry.weather_forecaster.repository.api.data.Weathers
import com.denailry.weather_forecaster.util.Util
import java.util.*
import kotlin.collections.ArrayList

class WeatherAdapter() : RecyclerView.Adapter<WeatherAdapter.ViewHolder>(){
    private var weathers: List<Weathers> = ArrayList()

    private val calendar = Calendar.getInstance()

    fun update(newWeathers: List<Weathers>) {
        weathers = newWeathers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.weather_item, parent, false)
        )
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.tvDay)
        val temp: TextView = itemView.findViewById(R.id.tvTemperature)
        val type: TextView = itemView.findViewById(R.id.tvWeatherType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = weathers[position]

        val day = Util.getDayName(item.dt)
        val type = item.weather[0].main

        holder.day.text = day
        holder.temp.text = Util.toCelciusString(item.main.temp)
        holder.type.text = type
    }

    override fun getItemCount(): Int {
        return weathers.size
    }
}