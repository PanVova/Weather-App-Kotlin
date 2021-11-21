package com.example.domain.gateway

import com.example.models.City
import com.example.models.WeatherCity
import kotlinx.coroutines.flow.Flow

interface WeatherGateway {
    fun getListOfCities(query: String): Flow<List<City>>
    fun getCity(city: Int): Flow<WeatherCity>
}