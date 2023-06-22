package com.puc.telias.weatherapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puc.telias.weatherapp.R
import com.puc.telias.weatherapp.databinding.RecyclerMainCityBinding
import com.puc.telias.weatherapp.models.CityStatus

class ListCityAdapter(
    private val context: Context,
    cities: List<CityStatus> = emptyList()
) : RecyclerView.Adapter<ListCityAdapter.ViewHolder>() {

    private val cities = cities.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerMainCityBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.size

    inner class ViewHolder(binding: RecyclerMainCityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CityStatus) {
            val cityName = itemView.findViewById<TextView>(R.id.main_city_name)
            val maxTemperature = itemView.findViewById<TextView>(R.id.main_max_temp)
            val minTemerature = itemView.findViewById<TextView>(R.id.main_min_temp)
            val condition = itemView.findViewById<TextView>(R.id.main_condition)

            cityName.text = item.name
            maxTemperature.text = item.maxTemperature.toString()
            minTemerature.text = item.minTemperature.toString()
            condition.text = item.condition
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedCity = cities[position]
                    //Toast.makeText(context, "Clicou em ${clickedCity.nome}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun update(cities: List<CityStatus>) {
        this.cities.clear()
        this.cities.addAll(cities)
        notifyDataSetChanged()
    }
}