package com.codingmart.bumf.model.TopMovies

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingmart.bumf.databinding.TopMoviesItemBinding

class TopMoviesHolder(var binding:TopMoviesItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindView(title: String?,description: String?,category: String?,image:String?,context: Context){
        Glide.with(context).load(image).into(binding.imageView)
        binding.movieName.text = title
        binding.movieCategory.text = category
        binding.movieDesc.text = description
    }
}