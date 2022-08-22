package com.codingmart.bumf.viewModel.topMovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TopMovieModelFactory(private val repository: TopMoviesRepository): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TopMoviesModel::class.java)) {
            TopMoviesModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}