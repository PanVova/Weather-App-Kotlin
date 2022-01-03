package com.weather.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.models.City
import com.weather.domain.useCase.GetWeatherCitiesUseCase
import com.weather.weatherapi.di.SearchScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@SearchScope
class SearchViewModel @Inject constructor(
    private val getWeatherCitiesUseCase: GetWeatherCitiesUseCase,
) : ViewModel() {

    private val _data = MutableLiveData<List<City>>()
    val data: LiveData<List<City>> = _data

    fun getCities(query: String) {
        viewModelScope.launch {
            getWeatherCitiesUseCase.loadCities(query)
                .catch {
                    Timber.e(it)
                }
                .collect {
                    _data.postValue(it)
                }
        }
    }
}


