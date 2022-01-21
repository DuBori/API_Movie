package com.example.movietest.data.repository

import com.example.movietest.domain.model.BookEntity
import io.reactivex.Single

interface BookRepository {

    fun get(query: String): Single<BookEntity>
}
