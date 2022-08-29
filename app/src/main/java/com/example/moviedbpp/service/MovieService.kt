package com.example.moviedbpp.service

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY="6f9ab437c43ec1fa9fb2dd9119d38c68"

interface MovieService {

    @GET("movie/popular")
    suspend fun getAllPopularMovies(
        @Query("api_key") api_key: String = API_KEY
    ): Response<MovieResponse>

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("api_key") api_key: String = API_KEY,

    ): Response<MovieResponse>

    companion object {

        val instance: MovieService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(MovieService::class.java)
        }
    }
}