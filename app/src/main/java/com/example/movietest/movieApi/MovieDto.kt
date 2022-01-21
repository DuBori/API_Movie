package com.example.movietest.movieApi

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDto(
    @SerializedName("movieNm")
    var movieNm: String?,
    @SerializedName("rankInten")
    var rankInten: String?,
    @SerializedName("rank")
    var rank: String?

) : Serializable {

}