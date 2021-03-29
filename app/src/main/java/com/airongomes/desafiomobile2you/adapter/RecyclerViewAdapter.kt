package com.airongomes.desafiomobile2you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airongomes.desafiomobile2you.MainActivityViewModel
import com.airongomes.desafiomobile2you.databinding.ItemRecyclerViewBinding
import com.airongomes.desafiomobile2you.network.MovieInfo
import com.airongomes.desafiomobile2you.network.SimilarMovieInfo

class RecyclerViewAdapter(
    var listMovies: List<SimilarMovieInfo> = listOf()
): RecyclerView.Adapter<AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
}

class AdapterViewHolder(val binding: ItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(similarMovieInfo: SimilarMovieInfo) {
        binding.similarMovieInfo = similarMovieInfo
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): AdapterViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemRecyclerViewBinding.inflate(layoutInflater, parent, false)
            return AdapterViewHolder(binding)
        }
    }
}