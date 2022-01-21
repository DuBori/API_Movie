package com.example.movietest.domain.usecase

import com.example.movietest.data.repository.BookRepository
import com.example.movietest.data.repository.MovieRepository
import com.example.movietest.domain.SingleUseCase
import com.example.movietest.domain.model.BookEntity
import com.example.movietest.domain.model.BookItemEntity
import com.example.movietest.domain.model.MovieEntity
import com.example.movietest.domain.model.MovieItemEntity
import com.example.movietest.util.SchedulersProvider
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class GetContentsUsecase(
    private val bookRepository: BookRepository,
    private val movieRepository: MovieRepository,
    schedulersProvider: SchedulersProvider
) : SingleUseCase<Pair<List<BookItemEntity>, List<MovieItemEntity>>, String>(
    schedulersProvider
) {
    override fun buildUseCaseSingle(params: String): Single<Pair<List<BookItemEntity>, List<MovieItemEntity>>> {
        return Single.zip(
            bookRepository.get(params),
            movieRepository.get(params),
            BiFunction<BookEntity, MovieEntity, Pair<List<BookItemEntity>, List<MovieItemEntity>>> {
                book, movie -> Pair(book.items, movie.items)
            }
        )
    }
}
