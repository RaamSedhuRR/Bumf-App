package com.codingmart.bumf.model.retrofit

import com.codingmart.bumf.BuildConfig
import com.codingmart.bumf.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("4c7854e8-9c77-4fc4-83e8-d42143d149d9")
    fun getTopMovies() : Call<List<Movie>>

    @GET("c26e5422-ac9b-4e3a-bfad-63a8cadc68f3")
    fun getNewMovies() : Call<List<Movie>>

    companion object{
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if(retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}