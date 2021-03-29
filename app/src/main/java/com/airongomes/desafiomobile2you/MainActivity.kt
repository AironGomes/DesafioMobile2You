package com.airongomes.desafiomobile2you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.airongomes.desafiomobile2you.adapter.RecyclerViewAdapter
import com.airongomes.desafiomobile2you.databinding.ActivityMainBinding
import com.airongomes.desafiomobile2you.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create instance of viewModel
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Associate viewModel with variable from layout
        binding.viewModel = viewModel

        // observe movieInfo livedata
        viewModel.movieInfo.observe(this, Observer {
        })

        // Create instance of recyclerview adapter
        val adapter = RecyclerViewAdapter(listOf())

        binding.recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        // observe similarMovies livedata
        viewModel.similarMovies.observe(this, Observer {
            adapter.listMovies = it.similarMovies
            adapter.notifyDataSetChanged()
        })

        binding.lifecycleOwner = this
    }
}

