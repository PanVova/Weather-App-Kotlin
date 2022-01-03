package com.weather.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.domain.useCase.GetWeatherCityUseCase
import com.weather.models.WeatherCity
import com.weather.weatherapi.di.CityScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@CityScope
class CityViewModel @Inject constructor(
    private val getWeatherCityUseCase: GetWeatherCityUseCase
) : ViewModel() {


    private val _data = MutableLiveData<WeatherCity>()
    val data: LiveData<WeatherCity> = _data

    fun getCity(city: Int) {
        viewModelScope.launch {
            getWeatherCityUseCase.loadCity(city).collect {
                _data.postValue(it)
            }
        }
    }
}


