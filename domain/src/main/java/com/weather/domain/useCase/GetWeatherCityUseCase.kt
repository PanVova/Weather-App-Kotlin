package com.weather.domain.useCase

import com.weather.models.WeatherCity
import com.weather.domain.gateway.WeatherGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherCityUseCase @Inject constructor(private val weatherGateway: WeatherGateway) {
    fun loadCity(city: Int): Flow<WeatherCity> {
        return weatherGateway.getCity(city)
    }
}