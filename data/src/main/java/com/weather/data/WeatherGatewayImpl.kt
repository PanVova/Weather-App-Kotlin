package com.weather.data

import com.weather.models.City
import com.weather.models.WeatherCity
import com.weather.domain.gateway.WeatherGateway
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