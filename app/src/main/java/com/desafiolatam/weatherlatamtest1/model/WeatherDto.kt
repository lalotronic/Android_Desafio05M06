package com.desafiolatam.weatherlatamtest1.model

data class WeatherDto(
    val id: Int,
    val currentTemp: Double,
    val maxTemp: Double,
    val minTemp: Double,
    val pressure: Double,
    val humidity: Double,
    val windSpeed: Double,
    val sunrise: Long,
    val sunset: Long,
    var cityName: String,
)
