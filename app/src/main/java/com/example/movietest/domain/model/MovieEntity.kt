package com.example.movietest.domain.model

data class MovieEntity (
     val lastBuildDate: String,
     val total: Int,
     val start: Int,
     val display: Int,
     val items: List<MovieItemEntity>
     )