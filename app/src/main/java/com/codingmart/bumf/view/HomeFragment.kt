package com.codingmart.bumf.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingmart.bumf.R
import com.codingmart.bumf.databinding.FragmentHomeBinding
import com.codingmart.bumf.model.TopMovies.TopMoviesAdapter
import com.codingmart.bumf.model.retrofit.RetrofitService
import com.codingmart.bumf.viewModel.newMovies.NewMoviesModel
import com.codingmart.bumf.viewModel.newMovies.NewMoviesModelFactory
import com.codingmart.bumf.viewModel.newMovies.NewMoviesRepository
import com.codingmart.bumf.viewModel.topMovies.TopMovieModelFactory
import com.codingmart.bumf.viewModel.topMovies.TopMoviesModel
import com.codingmart.bumf.viewModel.topMovies.TopMoviesRepository

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private val TAG = "Home Fragment"
    private val retrofitService = RetrofitService.getInstance()
    lateinit var viewModel : TopMoviesModel
    lateinit var adapter: TopMoviesAdapter
    lateinit var newMovieViewModel : NewMoviesModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        setUpVideoView("android.resource://"+
                (context?.packageName +"/"+R.raw.the_amazing_peter
                        ))

        binding.buttonOne.setOnClickListener {
            setUpVideoView("android.resource://"+
                    (context?.packageName +"/"+R.raw.kesariya ))
        }

        binding.buttonTwo.setOnClickListener{
            setUpVideoView("android.resource://"+
                    (context?.packageName +"/"+R.raw.sita_ramam ))
        }

        binding.buttonThree.setOnClickListener {
            setUpVideoView("android.resource://"+
                    (context?.packageName +"/"+R.raw.grayman ))
        }

        binding.buttonFour.setOnClickListener {
            setUpVideoView("android.resource://"+
                    (context?.packageName +"/"+R.raw.the_amazing_peter ))
        }
        //Top Movies
        getTopMovies()
        //New Movies
        getNewMovies()
        return binding.root
    }

    private fun getNewMovies() {
        newMovieViewModel = ViewModelProvider(this,NewMoviesModelFactory
            (NewMoviesRepository(retrofitService)))[NewMoviesModel::class.java]
        newMovieViewModel.movieList.observe(this.viewLifecycleOwner){
            adapter = TopMoviesAdapter(it,this.requireContext())
            binding.recyclerViewNewMovie.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerViewNewMovie.adapter = adapter
            Log.e(TAG, "onCreateView: $it")
        }
        newMovieViewModel.errorMessage.observe(this.viewLifecycleOwner){
            Log.e(TAG, "onCreateView: $it")
        }
        newMovieViewModel.getNewMovies()

    }

    private fun getTopMovies() {
        viewModel = ViewModelProvider(this,TopMovieModelFactory
            (TopMoviesRepository(retrofitService)))[TopMoviesModel::class.java]
        viewModel.movieList.observe(this.viewLifecycleOwner) {
            adapter = TopMoviesAdapter(it,this.requireContext())
            binding.recyclerViewTopMovie.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerViewTopMovie.adapter = adapter
            Log.e(TAG, "onCreateView: $it")
        }
        viewModel.errorMessage.observe(this.viewLifecycleOwner) {
            Log.e(TAG, "onCreateView: $it")
        }
        viewModel.getTopMovies()
    }

    private fun setUpVideoView(uriString: String) {
        //VideoView
        binding.videoView.stopPlayback()
        binding.videoView.setVideoURI(Uri.parse(uriString))
        val mediaController = MediaController(context)
        binding.videoView.setMediaController(mediaController)
        binding.videoView.start()
        mediaController.setAnchorView(binding.videoView)
        binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
            mediaController.hide()
        }
    }
}