package com.example.movietest.movieApi

import com.example.movietest.movieApi.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitMovieAPI2 {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json")
    fun getMovieList(
        @Query("targetDt") targetDt: String?,
        @Query("key") key: String?,
        @Query("weekGB") weekGB: Int?
    ): Call<MovieResponse>
}

//Service는 interface로선언하기 때문에
//구현할 필요는 없고 어떤 형태와
//방식으로 통신을 할지를
//어노테이션과 파라미터로 지정하면 된다.

