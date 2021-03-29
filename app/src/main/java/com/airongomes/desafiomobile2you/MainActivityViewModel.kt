package com.airongomes.desafiomobile2you

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airongomes.desafiomobile2you.network.MovieInfo
import com.airongomes.desafiomobile2you.network.SimilarMovies
import com.airongomes.desafiomobile2you.repository.Repository
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    // LiveData Movie Information
    private var _movieInfo = MutableLiveData<MovieInfo>()
    val movieInfo : LiveData<MovieInfo>
        get() = _movieInfo

    // LiveData SimilarMovies
    private var _similarMovies = MutableLiveData<SimilarMovies>()
    val similarMovies : LiveData<SimilarMovies>
        get() = _similarMovies

    init {
        connectApi()
    }

    /**
     * This function is responsible to use the repository class and require data by retrofit
     */
    private fun connectApi() {
        viewModelScope.launch {
            try {
                val resultMovieInfo = Repository().getMovieInfo()
                _movieInfo.value = resultMovieInfo
                //Log.d("Test", resultMovieInfo.toString())

                val resultSimilarMovies = Repository().getSimilarMovies()
                _similarMovies.value = resultSimilarMovies
                Log.d("Test", resultSimilarMovies.toString())


            } catch (e: Exception) {
                Log.d("Test", "Failure: ${e.message}")
            }
        }
    }
}