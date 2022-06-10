package com.example.weatherapi

import com.example.weatherapi.data.WeatherGatewayImpl
import com.example.weatherapi.domain.model.City
import com.example.weatherapi.domain.model.WeatherCity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GatewayTest {

    private val weatherGateway = WeatherGatewayImpl(weatherAPI = WeatherApiTest())

    @Test
    fun test_gateway_getCity() = runBlocking {

        lateinit var city: WeatherCity
        weatherGateway.getCity(0).collect {
            city = (it)
        }

        assertEquals("WeatherCityResponse", city.title)
    }

    @Test
    fun test_gateway_getListOfCities() = runBlocking {
        lateinit var city: City
        weatherGateway.getListOfCities("").collect { cities ->
             city = cities.last()
        }

        assertEquals("someTitleLatest", city.name)
    }
}