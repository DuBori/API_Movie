package com.example.movietest.presenter.model

import com.example.movietest.domain.model.BookItemEntity

data class BookItem(
    val title: String,
    val image: String
)

fun BookItemEntity.mapToPresentation(): BookItem = BookItem(
    title,
    image
)

fun List<BookItemEntity>.mapToPresentation(): MutableList<BookItem> =
    map { it.mapToPresentation() }.toMutableList()
