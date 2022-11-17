package com.example.droi_mvvm.model

import org.json.JSONObject

class GDTO {
    data class city(
        var id: String = "",
        var name: String = "",
        var country: String = "",
        var coord: coord = coord(),
    )

    data class coord(
        var lon: String = "",
        var lat: String = "",
    )
    data class coord_d(
        var lon: Double = 0.0,
        var lat: Double = 0.0,
    )
    data class weather(
        var id: Int = -1,
        var main: String = "",
        var description: String = "",
        var icon: String = "",
    )
    data class main(
        var temp: Double = 0.0,
        var feels_like: Double = 0.0,
        var temp_min: Double = 0.0,
        var temp_max: Double = 0.0,
        var pressure: Int = -1,
        var humidity: Int = -1,
        var sea_level: Int = -1,
        var grnd_level: Int = -1,
    )
    data class wind(
        var speed: Double = 0.0,
        var deg: Int = -1,
        var gust: Double = 0.0,
    )
    data class clouds(
        var all: Int = -1,
    )
    data class sys(
        var type: Int = -1,
        var id: Int = -1,
        var country: String = "",
        var sunrise: Int = -1,
        var sunset: Int = -1,
    )

    data class weather_base(
        var coord_d: coord_d = coord_d(),
        var weather: ArrayList<weather> = ArrayList(),
        var base: String = "",
        var main: main = main(),
        var visibility: Int = -1,
        var wind: wind = wind(),
        var clouds: clouds = clouds(),
        var dt: Int = -1,
        var sys: sys = sys(),
        var timezone: Int = -1,
        var id: Int = -1,
        var name: String = "",
        var cod: Int = -1,
    )
//    {"coord":{"lon":56.342,"lat":25.3313},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}],"base":"stations","main":{"temp":309.18,"feels_like":315.48,"temp_min":309.18,"temp_max":312.15,"pressure":1002,"humidity":48,"sea_level":1002,"grnd_level":1000},"visibility":10000,"wind":{"speed":2.92,"deg":45,"gust":3.71},"clouds":{"all":12},"dt":1630041678,"sys":{"type":1,"id":7540,"country":"AE","sunrise":1630029205,"sunset":1630075164},"timezone":14400,"id":291696,"name":"Khor'fakkan","cod":200}
}


