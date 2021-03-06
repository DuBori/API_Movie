package com.example.movietest.domain.model

data class BookEntity (
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<BookItemEntity>
)
