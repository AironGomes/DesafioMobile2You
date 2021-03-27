package com.airongomes.desafiomobile2you.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.airongomes.desafiomobile2you.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

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
                .error(R.drawable.ic_broken_image))
            .into(this)
    }

    if (pathImage == null) {
        setImageResource(R.drawable.ic_image)
    }

}