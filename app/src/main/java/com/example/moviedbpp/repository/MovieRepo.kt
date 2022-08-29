package com.example.moviedbpp.repository

import com.example.moviedbpp.service.MovieService


class MovieRepo(private val movieService: MovieService) {

    suspend fun getMovieRepoMovies() =
        movieService.getAllPopularMovies()

    suspend fun searchRepoMovie(movie:String) =
        movieService.searchMovie(movie)
}