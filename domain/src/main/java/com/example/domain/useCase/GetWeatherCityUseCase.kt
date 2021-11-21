package com.example.domain.useCase

import com.example.models.WeatherCity
import com.example.domain.gateway.WeatherGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherCityUseCase @Inject constructor(private val weatherGateway: WeatherGateway) {
    fun loadCity(city: Int): Flow<WeatherCity> {
        return weatherGateway.getCity(city)
    }
}