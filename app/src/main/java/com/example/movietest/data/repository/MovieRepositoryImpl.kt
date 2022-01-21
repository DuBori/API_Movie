package com.example.movietest.data.repository

import com.example.movietest.data.remote.NaverRemoteDataSource
import com.example.movietest.domain.model.MovieEntity
import io.reactivex.Single

class MovieRepositoryImpl(
    private val remoteDataSource: NaverRemoteDataSource
) : MovieRepository {

    override fun get(query: String): Single<MovieEntity> =
        remoteDataSource.getMovie(query)

    companion object {
        private var INSTANCE: MovieRepositoryImpl? = null

        fun getInstance(remoteDataSource: NaverRemoteDataSource) : MovieRepository =
            INSTANCE ?: MovieRepositoryImpl(remoteDataSource).apply {
                INSTANCE = this
            }
    }
}
