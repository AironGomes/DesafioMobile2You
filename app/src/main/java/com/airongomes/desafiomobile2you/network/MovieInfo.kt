package com.airongomes.desafiomobile2you.network

import com.squareup.moshi.Json

data class MovieInfo (
    @Json(name = "original_title") val title: String,
    @Json(name = "backdrop_path") val pathImage: String,
    @Json(name = "vote_count") val likes: Int,
    @Json(name = "popularity") val popularity: Double,
)

data class SimilarMovieInfo (
    @Json(name = "original_title") val title: String,
    @Json(name = "backdrop_path") val pathImage: String,
    @Json(name = "release_date") val date: String,
    @Json(name = "genre_ids") val genreIds: List<Int>,
)

data class SimilarMovies(
    @Json(name = "results") val similarMovies: List<SimilarMovieInfo>,
)

