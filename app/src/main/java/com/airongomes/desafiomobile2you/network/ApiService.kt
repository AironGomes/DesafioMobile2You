package com.airongomes.desafiomobile2you.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Api key
private const val KEY = "049bd5d43a2c836dfcef45c1e3b17deb"
// Base Url
private const val BASE_URL = "https://api.themoviedb.org"

// Moshi Builder
private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

// Retrofit Builder
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

/**
 * Requisition interface
 */
interface ApiService {
    @GET("/3/movie/508442?api_key=$KEY&language=en-US")
    suspend fun getMovieInfo(): MovieInfo

    @GET("/3/movie/508442/similar?api_key=$KEY&language=en-US&page=1")
    suspend fun getSimilarMovies(): SimilarMovies
}

/**
 * This object is responsible for creating the retrofit
 */
object Service {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}