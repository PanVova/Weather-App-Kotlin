package com.example.data

import com.example.models.City
import com.example.models.WeatherCity
import com.example.domain.gateway.WeatherGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherGatewayImpl(private val weatherAPI: WeatherAPI) : WeatherGateway {
    override fun getListOfCities(query: String): Flow<List<City>> {
        return flow { emit(weatherAPI.getListOfCities(query)) }
    }

    override fun getCity(city: Int): Flow<WeatherCity> {
        return flow { emit(weatherAPI.getCity(city)) }
    }
}