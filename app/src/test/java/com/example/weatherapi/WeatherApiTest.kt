package com.example.weatherapi

import com.example.weatherapi.data.WeatherAPI
import com.example.weatherapi.data.model.CityResponse
import com.example.weatherapi.data.model.WeatherCityResponse

class WeatherApiTest : WeatherAPI {
    override suspend fun getListOfCities(query: String): List<CityResponse> {
        return listOf(
            CityResponse(
                title = "someTitle",
                location_type = "",
                woeid = 0,
                latt_long = ""
            ),
            CityResponse(
                title = "someTitleLatest",
                location_type = "",
                woeid = 0,
                latt_long = ""
            )
        )
    }

    override suspend fun getCity(city: Int): WeatherCityResponse {
        return WeatherCityResponse(listOf(), "WeatherCityResponse")
    }
}