package com.codingmart.bumf.viewModel.newMovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingmart.bumf.model.Movie
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class NewMoviesModel(private val repository: NewMoviesRepository) : ViewModel(){
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getNewMovies(){
        val response = repository.getNewMovies()
        response.enqueue(object : retrofit2.Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}