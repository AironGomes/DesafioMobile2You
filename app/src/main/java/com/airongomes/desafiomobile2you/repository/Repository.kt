package com.airongomes.desafiomobile2you.repository

import com.airongomes.desafiomobile2you.network.MovieInfo
import com.airongomes.desafiomobile2you.network.Service.retrofitService

class Repository {

    suspend fun getMovieInfo(): MovieInfo {
        return retrofitService.getMovieInfo()
    }
}