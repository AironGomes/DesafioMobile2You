package com.airongomes.desafiomobile2you

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
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

        // Click to call changeIconLike function
        binding.iconLike.setOnClickListener{
            changeIconLike(it)
        }

        binding.lifecycleOwner = this
    }

    /**
     * Change the icon_like image with ObjectAnimator
     */
    private fun changeIconLike(view: View) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            view, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.changeViewState(view)
        animator.start()
    }

    /**
     * Extension function of ObjectAnimator to change state during animation
     */
    private fun ObjectAnimator.changeViewState(view: View) {
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationRepeat(animation: Animator?) {
                view.isActivated = !view.isActivated
            }
        })

    }
}

