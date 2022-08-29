package com.example.moviedbpp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedbpp.R
import com.example.moviedbpp.repository.MovieRepo
import com.example.moviedbpp.service.MovieService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movieService = MovieService.instance
        val movieRepo = MovieRepo(movieService)

        GlobalScope.launch {
//            val results = movieRepo.getMovieRepoMovies()
//            Log.d(TAG, "Results = ${results.body()}")

            val results = movieRepo.searchRepoMovie("The Avengers")
            Log.d(TAG, "Results = ${results.body()}")
            }
    }
}