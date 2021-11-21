package com.example.domain.useCase

import com.example.models.City
import com.example.domain.gateway.WeatherGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherCitiesUseCase @Inject constructor(private val weatherGateway: WeatherGateway) {
    fun loadCities(query: String): Flow<List<City>> {
        return weatherGateway.getListOfCities(query)
    }
}