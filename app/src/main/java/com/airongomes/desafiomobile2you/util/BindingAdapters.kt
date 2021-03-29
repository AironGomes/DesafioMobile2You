package com.airongomes.desafiomobile2you.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.airongomes.desafiomobile2you.R
import com.airongomes.desafiomobile2you.network.SimilarMovieInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

/**
 * Define the image_movie image in activity_main.xml
 */
@BindingAdapter("setImage")
fun ImageView.setImage(pathImage: String?) {
    pathImage?.let{
        val urlImage = "https://www.themoviedb.org/t/p/original$it"
        val uri = urlImage.toUri().buildUpon().scheme("https").build()
        Glide.with(this)
            .load(uri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_image)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }

    if (pathImage == null) {
        setImageResource(R.drawable.ic_image)
    }
}

/**
 * Define the text_info_likes text in activity_main.xml
 */
@BindingAdapter("showLikes")
fun TextView.showLikes(likes: Int?){
    likes?.let {
        val textString = abbreviateValue(it.toDouble()) + " Likes"
        text = textString
    }
    if (likes == null) {
        text = "0 Likes"
    }
}

/**
 * Define the text_info_popularity text in activity_main.xml
 */
@BindingAdapter("showPopularity")
fun TextView.showPopularity(value: Double?){
    value?.let {
        val textString = "Popularity: " + abbreviateValue(it)
        text = textString
    }
    if (value == null) {
        text = "Popularity: 0"
    }
}

/**
 * Define the info_thumbnail text in item_recycler_view.xml
 */
@BindingAdapter("showDetail")
fun TextView.showDetail(similarMovieInfo: SimilarMovieInfo?){
    var stringDetails = ""

    similarMovieInfo?.date?.let {
        val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val date = inputFormatter.parse(it) as Date
        val outputFormatter = SimpleDateFormat("yyyy", Locale.ENGLISH)
        stringDetails += outputFormatter.format(date)
    }
    similarMovieInfo?.genreIds?.let {
        stringDetails += " ${getGenreName(it)}"
    }
    text = stringDetails
}













