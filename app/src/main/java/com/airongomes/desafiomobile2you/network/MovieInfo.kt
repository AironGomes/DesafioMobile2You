package com.airongomes.desafiomobile2you.network

import com.squareup.moshi.Json

data class MovieInfo (
    @Json(name = "original_title") val title: String,
    @Json(name = "backdrop_path") val pathImage: String,
    @Json(name = "vote_count") val likes: Int,
    @Json(name = "popularity") val popularity: Double
    )