package com.example.movietest.movieApi

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("boxOfficeResult")
    var boxofficeResult: BoxOfficeResult?
)