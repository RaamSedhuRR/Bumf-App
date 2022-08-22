package com.codingmart.bumf.viewModel.topMovies

import com.codingmart.bumf.model.retrofit.RetrofitService

class TopMoviesRepository(private val retrofitService: RetrofitService) {
    fun getTopMovies() = retrofitService.getTopMovies()
}