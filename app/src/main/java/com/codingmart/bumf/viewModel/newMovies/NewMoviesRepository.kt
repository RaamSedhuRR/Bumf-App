package com.codingmart.bumf.viewModel.newMovies

import com.codingmart.bumf.model.retrofit.RetrofitService

class NewMoviesRepository(private val retrofitService: RetrofitService) {
    fun getNewMovies() = retrofitService.getNewMovies()
}