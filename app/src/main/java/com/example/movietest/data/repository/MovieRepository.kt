package com.example.movietest.data.repository

import com.example.movietest.domain.model.MovieEntity
import io.reactivex.Single

interface MovieRepository {

    fun get(query: String): Single<MovieEntity>
}
