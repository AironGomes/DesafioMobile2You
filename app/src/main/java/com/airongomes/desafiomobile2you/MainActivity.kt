package com.airongomes.desafiomobile2you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        binding.viewModel = viewModel

        viewModel.movieInfo.observe(this, Observer {
            Log.d("Test", "viewmodel: $it")
        })

        binding.lifecycleOwner = this
    }
}

