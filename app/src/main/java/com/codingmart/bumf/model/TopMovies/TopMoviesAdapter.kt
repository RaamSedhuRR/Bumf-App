package com.codingmart.bumf.model.TopMovies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingmart.bumf.databinding.TopMoviesItemBinding
import com.codingmart.bumf.model.Movie

class TopMoviesAdapter(val topMoviesList: List<Movie>, val context: Context)
    : RecyclerView.Adapter<TopMoviesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TopMoviesHolder(TopMoviesItemBinding
            .inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: TopMoviesHolder, position: Int) {
        holder.bindView(topMoviesList[position].name,topMoviesList[position].desc,
            topMoviesList[position].category,
        topMoviesList[position].imageUrl,context)
    }

    override fun getItemCount(): Int {
        return topMoviesList.size
    }
}