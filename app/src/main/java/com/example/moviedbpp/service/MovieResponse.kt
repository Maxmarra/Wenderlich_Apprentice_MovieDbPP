package com.example.moviedbpp.service

data class MovieResponse(
    val results: List<Movie>) {

    data class Movie(
        val id: Int,
        val original_title: String,
        val popularity: Double,
    )
}