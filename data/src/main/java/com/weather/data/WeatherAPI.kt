package com.weather.data


import com.weather.models.City
import com.weather.models.WeatherCity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {
    @GET("/api/location/search/?")
    suspend fun getListOfCities(@Query("query") query: String): List<City>

    @GET("/api/location/{location_id}/")
    suspend fun getCity(@Path("location_id") city: Int): WeatherCity
}