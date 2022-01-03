package com.weather.domain.gateway

import com.weather.models.City
import com.weather.models.WeatherCity
import kotlinx.coroutines.flow.Flow

interface WeatherGateway {
    fun getListOfCities(query: String): Flow<List<City>>
    fun getCity(city: Int): Flow<WeatherCity>
}