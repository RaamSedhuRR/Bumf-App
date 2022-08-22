package com.codingmart.bumf.viewModel.newMovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class NewMoviesModelFactory(private val repository: NewMoviesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewMoviesModel::class.java)){
            NewMoviesModel(this.repository) as T
        }else{
            throw IllegalArgumentException("View Model Not Found")
        }
    }
}