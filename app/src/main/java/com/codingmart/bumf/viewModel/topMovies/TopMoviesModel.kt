package com.codingmart.bumf.viewModel.topMovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingmart.bumf.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopMoviesModel(private val repository: TopMoviesRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getTopMovies(){
        val response = repository.getTopMovies()
        response.enqueue(object : Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
             movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }
}