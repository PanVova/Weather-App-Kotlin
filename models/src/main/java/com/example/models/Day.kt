package com.example.models

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("weather_state_name")
    var weatherStateName: String,

    @SerializedName("weather_state_abbr")
    var weatherStateAbbr: String,

    @SerializedName("applicable_date")
    var applicableDate: String,

    @SerializedName("min_temp")
    var minTemp: Float,

    @SerializedName("max_temp")
    var maxTemp: Float,
)

