package com.example.movietest.data.remote

import com.example.movietest.domain.model.BookEntity
import com.example.movietest.domain.model.MovieEntity
import io.reactivex.Single

interface NaverRemoteDataSource {

    fun getMovie(
        query: String
    ): Single<MovieEntity>

    fun getBook(
        query: String
    ): Single<BookEntity>
}
