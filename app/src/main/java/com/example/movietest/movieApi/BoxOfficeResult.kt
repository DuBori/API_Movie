package com.example.movietest.movieApi

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList: List<MovieDto> = arrayListOf(),
    @SerializedName("weeklyBoxOfficeList")
    var weeklyBoxOfficeList: List<MovieDto2> = arrayListOf()
)