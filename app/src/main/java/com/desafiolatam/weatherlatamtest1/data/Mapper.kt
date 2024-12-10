package com.desafiolatam.weatherlatamtest1.data

import com.desafiolatam.weatherlatamtest1.data.local.WeatherEntity
import com.desafiolatam.weatherlatamtest1.data.local.WeatherWrapper
import com.desafiolatam.weatherlatamtest1.model.WeatherDto

fun WeatherWrapper.toWeatherDto() = WeatherDto(
    id = 0,
    currentTemp = main.temp,
    maxTemp = main.temp_max,
    minTemp = main.temp_min,
    pressure = main.pressure.toDouble(),
    humidity = main.humidity.toDouble(),
    windSpeed = wind.speed,
    sunrise = sys.sunrise,
    sunset = sys.sunset,
    cityName = "${name}, ${sys.country}",
)

fun WeatherWrapper.toWeatherEntity() = WeatherEntity(
    id = 0,
    currentTemp = main.temp,
    maxTemp = main.temp_max,
    minTemp = main.temp_min,
    pressure = main.pressure.toDouble(),
    humidity = main.humidity.toDouble(),
    windSpeed = wind.speed,
    sunrise = sys.sunrise,
    sunset = sys.sunset,
    cityName = "${name}, ${sys.country}",
)

fun WeatherDto.toEntity(): WeatherEntity = WeatherEntity(
    id = id,
    currentTemp = currentTemp,
    maxTemp = maxTemp,
    minTemp = minTemp,
    pressure = pressure,
    humidity = humidity,
    windSpeed = windSpeed,
    sunrise = sunrise,
    sunset = sunset,
    cityName = cityName,
)

fun entityToDto(entity: WeatherEntity): WeatherDto = WeatherDto(
    id = entity.id,
    currentTemp = entity.currentTemp,
    maxTemp = entity.maxTemp,
    minTemp = entity.minTemp,
    pressure = entity.pressure,
    humidity = entity.humidity,
    windSpeed = entity.windSpeed,
    sunrise = entity.sunrise,
    sunset = entity.sunset,
    cityName = entity.cityName,
)

fun entityListToDtoList(list: List<WeatherEntity>): List<WeatherDto> = list.map(::entityToDto)