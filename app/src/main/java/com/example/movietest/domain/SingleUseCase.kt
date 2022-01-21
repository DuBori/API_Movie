package com.example.movietest.domain

import com.example.movietest.util.SchedulersProvider
import io.reactivex.Single

abstract class SingleUseCase<T, in Params>(
    private val schedulersProvider: SchedulersProvider
) {
    protected abstract fun buildUseCaseSingle(params: Params): Single<T>

    fun get(params: Params) = buildUseCaseSingle(params)
        .subscribeOn(schedulersProvider.io())
        .observeOn(schedulersProvider.ui())
}
