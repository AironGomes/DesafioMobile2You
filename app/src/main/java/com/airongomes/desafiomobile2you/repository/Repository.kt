package com.airongomes.desafiomobile2you.repository

import com.airongomes.desafiomobile2you.network.MovieInfo
import com.airongomes.desafiomobile2you.network.Service.retrofitService
import com.airongomes.desafiomobile2you.network.SimilarMovies

/**
 * Repository Class
 */
class Repository {

    /**
     * Request movie information by Retrofit
     */
    suspend fun getMovieInfo(): MovieInfo {
        return retrofitService.getMovieInfo()
    }

    /**
     * Request list of similar movies by Retrofit
     */
    suspend fun getSimilarMovies(): SimilarMovies {
        return retrofitService.getSimilarMovies()
    }
}